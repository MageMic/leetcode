package concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * @Author: zjumic
 * @Date: created at 23:08 2020/3/4
 */
public class PointUsingStampedLock {

    private int x, y;
    final StampedLock sl = new StampedLock();

    double distanceFromOrigin() {
        long stamp = sl.tryOptimisticRead();
        int curX = x, curY = y;
        // 判断执行读期间是否存在写操作
        // 如果存在，则sl.validate返回false
        if (!sl.validate(stamp)) {
            // 升级为悲观读锁
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(curX * curX + curY * curY);
    }
}
