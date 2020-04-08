package other;

/**
 * @Author: zjumic
 * @Date: created at 18:03 2020/3/27
 */
public class Jiayouzhan_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total = 0;
        int current = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            // 如果current<0，当前出发不能到达下一站，以下一站为起点，清空邮箱
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
        // 如果总油比总cost多，可以走完，取start
        return total >= 0 ? start: -1;
    }
}
