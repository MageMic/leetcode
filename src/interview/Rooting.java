package interview;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: zjumic
 * @Date: created at 22:41 2020/3/8
 */
public class Rooting {

    public double rooting(double target, int precision) {
        double g = 1;
        if (target < 0 || precision < 0) {
            return -1;
        }

        while (precision-- > 0) {
            g *= 10;
        }
        g = 1 / g;

        double result = target;
        double small = target > 1 ? 0 : target;
        double big = target > 1 ? target : 1;

        while (true) {
            double diff = result * result - target;
            if (Math.abs(diff) < g) {
                break;
            }
            if (diff > 0) {
                big = result;
            } else {
                small = result;
            }
            result = (big + small) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Rooting r = new Rooting();
        double res = r.rooting(12, 3);

        System.out.println(res);
    }
}
