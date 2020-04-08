package pattern;

/**
 * @Author: zjumic
 * @Date: created at 13:06 2020/3/18
 */
public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {}
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
