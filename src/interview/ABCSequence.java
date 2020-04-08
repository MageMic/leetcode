package interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zjumic
 * @Date: created at 0:50 2020/3/12
 */
public class ABCSequence {

    public static class Worker implements Runnable {
        private Semaphore current;
        private Semaphore next;
        private String key;
        private int count;

        public Worker(Semaphore current, Semaphore next, String key, int count) {
            this.current = current;
            this.next = next;
            this.key = key;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                try {
                    current.acquire();
                    System.out.println(key);
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);
        new Thread(new Worker(semaphoreA, semaphoreB, "A", 10)).start();
        new Thread(new Worker(semaphoreB, semaphoreC, "B", 10)).start();
        new Thread(new Worker(semaphoreC, semaphoreA, "C", 10)).start();
    }
}
