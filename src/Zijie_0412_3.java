import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 20:26 2020/4/12
 */
public class Zijie_0412_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Long> coupon = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> price = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0 ; i< n; i++) {
            coupon.offer(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            price.offer(sc.nextLong());
        }
        long cost = 0;
        for (long p : price) {
            while (!coupon.isEmpty() && p < coupon.peek()) {
                coupon.poll();
            }
            if (coupon.isEmpty()) {
                cost += p;
            } else {
                cost += p - coupon.peek();
            }
        }
        System.out.println(cost);
    }
}
