package practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 13:20 2020/3/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        for (int i = 0; i < n; i++) {
            String s = cin.nextLine();
            System.out.println(canUpdate(s));
        }
//        String s = "6.6.6 6.6.7";
//        System.out.println(canUpdate(s));
    }

    private static boolean canUpdate(String s) {
        String[] versions = s.split(" ");
        String[] v1 = versions[0].split("\\.");
        String[] v2 = versions[1].split("\\.");
        int j = 0;
        for (int i = 0; i < v1.length; i++) {
            if (i > v2.length) {
                return false;
            }
            if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return false;
            }
            j = i + 1;
        }
        if (j == v2.length) return true;
        while (j < v2.length) {
            if (Integer.parseInt(v2[j]) > 0) {
                return true;
            }
            j++;
        }
        return false;
    }
    private static boolean ifSquareSum(int num) {
        HashSet<Integer> set = new HashSet<>();
        int newNum = num;
        boolean result = false;
        while (!set.contains(newNum)) {
            if (newNum == 1) {
                result = true;
                break;
            } else {
                set.add(newNum);
                int sum = 0;
                while (newNum > 0) {
                    int a = newNum % 10;
                    sum += a * a;
                    newNum /= 10;
                }
                newNum = sum;
            }
        }
        return result;
    }
}
