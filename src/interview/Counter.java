package interview;

import java.util.concurrent.CountDownLatch;

public class Counter {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    System.out.println(10 - countDownLatch.getCount());
                }
            }).run();
        }

        System.out.println("helloworld");
        String s1 = "helloworld";
        String s2 = "helloworld";
        System.out.println(s1 == s2);
    }
}
