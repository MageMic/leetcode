import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 19:55 2020/4/10
 */
public class PDD3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String num = sc.nextLine();
        String res = checkNum(num, k);
        System.out.println(cost);
        System.out.println(res);
    }
    private static int cost = 0;
    private static String checkNum(String num, int k) {
        char[] arr = num.toCharArray();

        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] -'0';
        }
        int target = (int)Math.round(sum / arr.length);
        PriorityQueue<int[]> pr = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff1 = o1[0] - target;
                int diff2 = o2[0] - target;
                if (diff1 == diff2) {
                    if (diff1 > 0) {
                        return o1[1] - o2[1];
                    } else
                        return o2[1] - o1[1];
                } else if (Math.abs(diff1) == Math.abs(diff2)) {
                    if (diff1 < 0) {
                        return diff2 - diff1;
                    } else {
                        return diff1 - diff2;
                    }
                }
                return Math.abs(diff1) > Math.abs(diff2) ? 1 : -1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0' + target) {
                int[] cand = new int[2];
                cand[0] = arr[i] - '0';
                cand[1] = i;
                pr.offer(cand);
            } else {
                k--;
            }
        }

        while (k-- > 0) {
            int[] cand = pr.poll();
            cost += Math.abs(cand[0] - target);
            arr[cand[1]] = (char)('0' + target);
        }
        return new String(arr);
    }
}
