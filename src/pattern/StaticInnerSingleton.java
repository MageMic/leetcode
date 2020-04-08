package pattern;

/**
 * @Author: zjumic
 * @Date: created at 13:14 2020/3/18
 */
public class StaticInnerSingleton {
    private static class InstanceHolder {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }
    private StaticInnerSingleton() {}
    public static StaticInnerSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
