package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares_279 {
    private class Pair {
        private int key;
        private int val;
        Pair(int k, int v) {
            this.key = k;
            this.val = v;
        }
        int getKey() {
            return key;
        }
        int getVal() {
            return val;
        }
    }
    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, 0));
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int num = cur.getKey();
            int step = cur.getVal();
            if (num == 0) {
                return step;
            }
            for (int i = 1;;i++) {
                int a = num - i * i;
                if (a < 0) {
                    break;
                }
                if (!visited[a]) {
                    queue.add(new Pair(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return  -1;
    }
}
