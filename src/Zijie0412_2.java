import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 20:09 2020/4/12
 */

// 拆分一个数，使其变成递增子序列
public class Zijie0412_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(find(nums));
    }

    private static int find(int[] nums) {
        int count = 0;
        int start = 0;
        List<Integer> strangeList = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            } else {
                count++;
                strangeList.add(i);
            }
        }
        if (strangeList.isEmpty()) {
            return 0;
        }
        int times = 0;

        for (int index : strangeList) {
            int left = 0;
            if (index != 0) {
                left = nums[index - 1];
            }
            int right = nums[index + 1];
            if (left + right < nums[index]) {
                return 0;
            } else {
                times++;
            }
        }
        return times;
    }
}
