package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zjumic
 * @Date: created at 16:36 2020/3/5
 */
public class TeaUsingFutureTask {

    class T1Task implements Callable<String> {

        FutureTask<String> ft2;
        T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }
        @Override
        public String call() throws Exception {
            System.out.println("T1: 洗水壶...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("T1: 烧开水...");
            TimeUnit.SECONDS.sleep(15);

            String tf = ft2.get();
            System.out.println("T1: 拿到茶叶: " + tf);
            System.out.println("T1: 泡茶");
            return "上茶: " + tf;
        }
    }

    class T2Task implements Callable<String>{
        @Override
        public String call() throws Exception {

            System.out.println("T2: 洗茶壶...");
            TimeUnit.SECONDS.sleep(1);

            System.out.println("T2: 洗茶杯...");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("T2: 拿茶叶...");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }

    void doTea() {
        FutureTask<String> ft2 = new FutureTask<>(new T2Task());
        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        Thread t1 = new Thread(ft1);
        t1.start();
        Thread t2 = new Thread(ft2);
        t2.start();

        try {
            System.out.println(ft1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TeaUsingFutureTask task = new TeaUsingFutureTask();
        task.doTea();
    }
}
