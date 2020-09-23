package tengxun;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 19:27 2020/4/7
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a1 = new int[n];
        for (int i = 0; i < n; i++) {
            a1[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] a2 = new int[m];
        for (int i = 0; i < m; i++) {
            a2[i] = in.nextInt();
        }

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (a1[i] > a2[j]) {
                i++;
            } else if (a2[j] > a1[i]) {
                j++;
            } else {
                res.add(a1[i]);
                i++;
                j++;
            }
        }
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
