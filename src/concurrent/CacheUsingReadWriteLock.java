package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: zjumic
 * @Date: created at 22:29 2020/3/4
 */
public class CacheUsingReadWriteLock {

    class CachedData {
        Object data;
        volatile boolean cacheValid = false;
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        final Lock r = readWriteLock.readLock();
        final Lock w = readWriteLock.writeLock();

        void processCachedData() throws InterruptedException {
            r.lock();
            if (!cacheValid) {
                r.unlock();
                w.lock();
                try {
                    if (!cacheValid) {
                        data = Thread.currentThread().getName() + "正在缓存";
                        System.out.println(data);
                        Thread.sleep(2000);
                        cacheValid = true;
                    }
                    r.lock();
                } finally {
                 w.unlock();
                }
            }
            try {
                data = Thread.currentThread().getName() + "读取缓存";
                System.out.println(data);
            } finally {
                r.unlock();
            }
        }
    }

    public static void main(String[] args) {
        CachedData cachedData = new CacheUsingReadWriteLock().new CachedData();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    cachedData.processCachedData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
