package pattern;

/**
 * @Author: zjumic
 * @Date: created at 13:12 2020/3/18
 */
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();
    private HungrySingleton() {}
    public static HungrySingleton getInsance() {
        return INSTANCE;
    }
}
