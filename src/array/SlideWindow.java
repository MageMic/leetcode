package array;

import java.util.Deque;
import java.util.LinkedList;

// 滑动窗口
public class SlideWindow {

    public int[] slide(int[] arr, int n, int w) {
        // write code here
        Deque<Integer> qmax = new LinkedList<>();
        int[] res = new int[n - w + 1];
        for (int i = 0; i < n; i++) {
            if (!qmax.isEmpty() && qmax.peekFirst() <= i - w) {
                qmax.pollFirst();
            }

            int cur = arr[i];
            if (qmax.isEmpty() || cur < arr[qmax.peekLast()]) {
                qmax.addLast(i);
            } else {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= cur) {
                    qmax.removeLast();
                }
                qmax.addLast(i);
            }

            if (i >= w - 1) {
                res[i - w + 1] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlideWindow slideWindow = new SlideWindow();
        int[] res = slideWindow.slide(new int[] {4,3,5,4,3,3,6,7}, 8, 3);
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
