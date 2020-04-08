package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zjumic
 * @Date: created at 23:57 2020/3/21
 */

// 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
//
//如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
//
//你允许：
//
//装满任意一个水壶
//清空任意一个水壶
//从一个水壶向另外一个水壶倒水，直到装满或者倒空
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/water-and-jug-problem
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class CanMeasureWater_365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        Queue<Pair<Integer>> queue = new LinkedList<>();
        Pair<Integer> start = new Pair<>(0, 0);
        queue.offer(start);
        HashSet<Pair<Integer>> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            Pair<Integer> curPair = queue.poll();
            int curX = curPair.getKey();
            int curY = curPair.getValue();
            if (curX == z || curY == z || curX + curY == z) {
                return true;
            }
            if (curX == 0) {
                addToQueue(new Pair<>(x, curY), queue, visited);
            }
            if (curY == 0) {
                addToQueue(new Pair<>(curX, y), queue, visited);
            }
            if (curY < y) {
                addToQueue(new Pair<>(0, curY), queue, visited);
            }
            if (curX < x) {
                addToQueue(new Pair<>(curX, 0), queue, visited);
            }

            int moveFromXToY = Math.min(curX, y - curY);
            addToQueue(new Pair<>(curX - moveFromXToY, curY + moveFromXToY), queue, visited);
            int moveFromYToX = Math.min(x - curX, curY);
            addToQueue(new Pair<>(curX + moveFromYToX, curY - moveFromYToX), queue, visited);
        }
        return false;
    }

    private void addToQueue(Pair<Integer> pair, Queue<Pair<Integer>> queue, HashSet<Pair<Integer>> visited) {
        if (!visited.contains(pair)) {
            queue.offer(pair);
            visited.add(pair);
        }
    }

    public static void main(String[] args) {
        CanMeasureWater_365 s = new CanMeasureWater_365();
        System.out.println(s.canMeasureWater(2,6,5));
    }
}
