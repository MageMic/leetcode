package array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: zjumic
 * @Date: created at 21:00 2020/3/25
 */
// two sum 有重复的数且无序
// 例  1 3 1 2 2 3， target 4
//返回【0 1，1 2，3 4， 0 5， 2 5】
public class TwoSumNotUnique {

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,1,2,2,3};
        ArrayList<int[]> result = twoSum(arr, 4);
        result.forEach(r -> {
            System.out.print(r[0] + " " + r[1] + "; ");
        });
    }

    public static ArrayList<int[]> twoSum(int[] arr, int target) {
        ArrayList<int[]> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            ArrayList<Integer> list;
            if (!map.containsKey(cur)) {
                list = new ArrayList<>();
            } else {
                list = map.get(cur);
            }
            list.add(i);
            map.put(cur, list);
        }
        for (int i = 0; i < arr.length; i++) {
            int residual = target - arr[i];
            if (map.containsKey(residual)) {
                for (int index : map.get(residual)) {
                    if (i < index)
                        result.add(new int[] {i, index});
                }
            }
        }
        return result;
    }
}
