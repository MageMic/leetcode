package binary_search;

import java.util.Arrays;

/**
 * @Author: zjumic
 * @Date: created at 23:17 2020/3/9
 */
// Koko 每⼩时最多吃⼀堆⾹蕉， 如果吃不下的话留到下⼀⼩时再
//吃； 如果吃完了这⼀堆还有胃⼝， 也只会等到下⼀⼩时才会吃下⼀堆。 在这
//个条件下， 让我们确定 Koko 吃⾹蕉的最⼩速度（根/⼩时） 。
public class EatingBanana {

    public int bruteSolution(int[] piles, int H) {
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = max + 1;
        while (left < right) {
            int speed = left + (right - left) / 2;
            if (canFinish(piles, speed, H)) {
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        return left;
    }
    public int binarySearch(int[] piles, int H) {
        int max = Arrays.stream(piles).max().getAsInt();
        for (int s = 1; s < max; s++) {
            if (canFinish(piles, s, H)) {
                return s;
            }

        }
        return max;
    }

    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] <= speed) {
                time++;
            } else {
                time += Math.ceil((double)piles[i] / speed);
            }
        }
        if (time <= H) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        EatingBanana eatingBanana = new EatingBanana();
        int[] piles = new int[] {3,6,7,11};
        int time = eatingBanana.bruteSolution(piles, 8);
        System.out.println(time);
    }
}
