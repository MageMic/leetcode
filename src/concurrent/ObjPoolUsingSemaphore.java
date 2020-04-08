package concurrent;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @Author: zjumic
 * @Date: created at 22:01 2020/3/4
 */
public class ObjPoolUsingSemaphore {

    static class ObjPool<T, R> {
        final List<T> pool;
        final Semaphore sem;

        ObjPool(int size, T t) {
            pool = new Vector<T>();
            for (int i = 0; i < size; i++) {
                pool.add(t);
            }
            sem = new Semaphore(size);
        }

        R exec(Function<T, R> func) throws InterruptedException {
            T t = null;
            sem.acquire();
            try {
                t = pool.remove(0);
                Thread.sleep(1000);
                return func.apply(t);
            } finally {
                pool.add(t);
                sem.release();
            }
        }
    }

    public static void main(String[] args) {
        ObjPool<Integer, String> pool = new ObjPool<Integer, String>(10, 3);
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println(pool.exec(t -> t.toString() + Thread.currentThread().getName() + " " + pool.sem.getQueueLength()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
