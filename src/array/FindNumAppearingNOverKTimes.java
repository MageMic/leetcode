package array;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 20:09 2020/3/21
 */

public class FindNumAppearingNOverKTimes {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 3, 3, 4, 5, 3, 2, 4, 5, 3, 5};
        ArrayList<Integer> list = find(nums, 6);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
    // 找到数组中出现次数超过n/k次数的数，没有返回0
    public static ArrayList<Integer> find(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k < 2) {
            System.out.println("k需要大于2");
            return result;
        }
        HashMap<Integer, Integer> cands = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cands.containsKey(nums[i])) {
                cands.put(nums[i], cands.get(nums[i]));
            } else {
                if (cands.size() == k - 1) {
                    allCandsRemoveOne(cands);
                } else {
                    cands.put(nums[i], 1);
                }
            }
        }
        HashMap<Integer, Integer> reals = getReals(nums, cands);
        for (Map.Entry<Integer, Integer> real : reals.entrySet()) {
            int key = real.getKey();
            int times = real.getValue();
            if (times > nums.length / k) {
                result.add(key);
            }
        }
        return result;
    }

    private static void allCandsRemoveOne(HashMap<Integer, Integer> cands) {
        List<Integer> removeList = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : cands.entrySet()) {
            int key = entry.getKey();
            int times = entry.getValue();
            if (times == 1) {
                removeList.add(key);
            } else {
                cands.put(key, times - 1);
            }
        }
        for (int toRemove : removeList) {
            cands.remove(toRemove);
        }
    }

    private static HashMap<Integer, Integer> getReals(int[] nums, HashMap<Integer, Integer> cands) {
        HashMap<Integer, Integer> reals = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cands.containsKey(nums[i])) {
                if (!reals.containsKey(nums[i])) {
                    reals.put(nums[i], 1);
                } else {
                    reals.put(nums[i], reals.get(nums[i]) + 1);
                }
            }
        }
        return reals;
    }
}
