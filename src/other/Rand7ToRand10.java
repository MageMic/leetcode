package other;

import java.util.Random;

/**
 * @Author: zjumic
 * @Date: created at 16:30 2020/3/28
 */
public class Rand7ToRand10 {

    public static void main(String[] args) {
        Rand7ToRand10 r = new Rand7ToRand10();
        for (int i = 0; i < 100; i++) {
            System.out.println(r.rand10());
        }
    }
    public int rand10() {
        int num;
        while ((num = (rand7() - 1) * 7 + rand7()) > 10) {

        }
        return num;
    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
