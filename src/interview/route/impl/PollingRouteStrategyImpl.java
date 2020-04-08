package interview.route.impl;

import interview.route.RouteStrategy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zjumic
 * @Date: created at 14:26 2020/3/21
 */
public class PollingRouteStrategyImpl implements RouteStrategy {

    private int index;
    private Lock lock = new ReentrantLock();

    @Override
    public <T> T select(List<T> primeList) {

        T point = null;
        try {
            lock.tryLock(10, TimeUnit.MILLISECONDS);
            if (index >= primeList.size()) {
                index = 0;
            }
            point = primeList.get(index++);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        if (null == point) {
            point = primeList.get(new Random().nextInt(primeList.size()));
        }
        return point;
    }
}
