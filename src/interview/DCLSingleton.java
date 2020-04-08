package interview;

/**
 * @Author: zjumic
 * @Date: created at 20:41 2020/3/8
 */
public class DCLSingleton {

    private static volatile DCLSingleton instance;
    private DCLSingleton() {}

    public DCLSingleton getInstance() {
        if (instance != null) {
            synchronized (this) {
                if (instance != null) {
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
