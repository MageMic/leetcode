package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 19:08 2020/4/10
 */
public class PDD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(sc.nextInt());
        }
        prices.sort(Comparator.reverseOrder());
        System.out.println(minMoney(prices));
    }

    private static int minMoney(List<Integer> prices) {
        if (prices.isEmpty()) {
            return 0;
        }
        if (prices.size() < 3) {
            int sum = 0;
            for (int i : prices) {
                sum += i;
            }
            return sum;
        }

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += prices.get(i);
        }

        return sum + minMoney(prices.subList(3, prices.size()));
    }
}
