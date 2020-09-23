import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 19:06 2020/4/12
 */

// 左右能看见的更矮的楼数
public class Zijie0412_4 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            int[] nums = new int[n];
//            for (int j = 0; j < n; j++) {
//                nums[j] = sc.nextInt();
//            }
//            for (int num : findHight(nums)) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
        int[] nums = new int[] {1,3,4,5,2,3,8,3,9};
        for (int num : findHight(nums)) {
            System.out.print(num + " ");
        }
    }

    private static int[] findHight(int[] nums) {
        int[] res = new int[nums.length];
        HashMap<Integer, Integer> left = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // 从左边开始，记录下一个比它大的楼的坐标
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                left.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left.put(stack.pop(), -1);
        }

        HashMap<Integer, Integer> right = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums.length; i++) {
            int rightBig = left.get(i), leftBig = right.get(i);
            if (rightBig == -1 && leftBig == -1) {
                res[i] = nums.length - 1;
            } else if (rightBig == -1) {
                res[i] = nums.length - leftBig - 2;
            } else if (leftBig == -1) {
                res[i] = rightBig - 1;
            } else {
                res[i] = rightBig - leftBig - 2;
            }
        }
        return res;
    }
}
