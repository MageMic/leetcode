package ali;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 14:12 2020/4/6
 */
// 有N个怪兽，M个弓箭，每个怪兽有生命值，每个弓箭有杀伤力和价值，
// 每个怪兽只能用一支弓箭攻击，弓箭杀伤>=怪兽生命时可消灭怪兽，求使用弓箭的最小价值。
public class MonsterArrow_0401 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        ArrayList<Integer> mon = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            mon.add(in.nextInt());
        }
        ArrayList<int[]> arrow = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] arr = new int[2];
            arr[1] = in.nextInt();
            arrow.add(arr);
        }
        for (int i = 0; i < M; i++) {
            int[] arr = arrow.get(i);
            arr[0] = in.nextInt();
        }
        System.out.println(monster(mon, arrow));
    }

    public static int monster(ArrayList<Integer> mon, ArrayList<int[]> arrow) {
        mon.sort(Comparator.reverseOrder());
        arrow.sort((a1, a2) -> a2[0] - a1[0]);

        PriorityQueue<int[]> available = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);

        int value = 0;
        int j = 0;
        for (int m : mon) {
            while (j < arrow.size() && arrow.get(j)[0] >= m) {
                available.add(arrow.get(j));
                j++;
            }
            if (available.isEmpty()) {
                return -1;
            } else {
                value += available.poll()[1];
            }
        }
        return value;
    }
}
