package interview;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @Author: zjumic
 * @Date: created at 16:16 2020/3/12
 */
public class OOM {

    private static class OOMObject {}

    public static void main(String[] args) throws IllegalAccessException {
        ArrayList<OOMObject> list = new ArrayList<>();
//        while(true) {
//            list.add(new OOMObject());
//        }

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

    private static final int _1MB = 1024 * 1024;


}
