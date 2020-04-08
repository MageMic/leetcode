package pattern;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: zjumic
 * @Date: created at 13:22 2020/3/18
 */
public class CASSingleton {
    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();
    private CASSingleton() {}
    public CASSingleton getInstance() {
        for(;;) {
            CASSingleton current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new CASSingleton();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }
}
