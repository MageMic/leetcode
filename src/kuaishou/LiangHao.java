package kuaishou;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 19:50 2020/3/22
 */
public class LiangHao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] nums = str.split(",");
//        String num = "13588654234";
//        System.out.println(countBaozi(num));
        List<String> result = new ArrayList<>();
        for (String num : nums) {
            if (countBaozi(num) >= 3 || countShunzi(num) >= 3) {
                result.add(num);
            }
        }

        Collections.sort(result,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int baozi1 = countBaozi(o1), shunzi1 = countShunzi(o1);
                int baozi2 = countBaozi(o2), shunzi2 = countShunzi(o2);
                if (Math.max(baozi1, shunzi1) == Math.max(baozi2, shunzi2)) {
                    if (baozi1 >= shunzi1) {
                        if (baozi2 >= shunzi2) {
                            return 0;
                        } else return -1;
                    } else {
                        if (baozi2 < shunzi2) {
                            return 0;
                        } else {
                            return - 1;
                        }
                    }
                } else if (Math.max(baozi1, shunzi1) > Math.max(baozi2, shunzi2)) {
                    return -1;
                }
                return 1;
            }
        });
        if (result.isEmpty()) {
            System.out.println("null");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i != result.size() - 1) System.out.print(",");
            }
        }
    }

    private static int countBaozi(String s) {
        char[] num = s.toCharArray();
        int count = 1, minusCount = 1;
        int result = 0;
        for (int i = 4; i < num.length; i++) {
            if (num[i] == num[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    private static int countShunzi(String s) {
        char[] num = s.toCharArray();
        int count = 1, minusCount = 1;
        int result = 0;
        for (int i = 4; i < num.length; i++) {
            if (num[i] - num[i - 1] == 1) {
                count++;
            } else {
                count = 1;
            }
            if (num[i] - num[i - 1] == -1) {
                minusCount++;
            } else {
                minusCount = 1;
            }
            result = Math.max(result, Math.max(count, minusCount));
        }
        return result;
    }
}
