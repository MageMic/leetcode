package interview;

import java.util.ArrayList;
import java.util.Stack;

public class ForTest {
    public int findPos(int[] arr, int n) {
        // write code here
        if (arr[0] > n - 1 || arr[n - 1] < 0) {
            return -1;
        }

        int lo = 0, hi = n - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == mid) {
                res = mid;
                hi = mid - 1;
            } else {
                if (arr[mid] < mid) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ForTest test = new ForTest();
        System.out.println(test.findPos(new int[] {0,2,7}, 3));
    }
}
