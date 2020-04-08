package interview.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zjumic
 * @Date: created at 20:03 2020/3/30
 */
public class PAndC {

    public abstract class Event {
        private String eventName;
        private String eventCtx;
        Event(String eventName, String eventCtx) {
            this.eventName = eventName;
            this.eventCtx = eventCtx;
        }
    }

    public static BlockingQueue<Event> blockingQueue = new ArrayBlockingQueue<>(10);

    public class Producer {
        boolean fireEvent(Event event) {
            boolean ret = false;
            try {
                 if (blockingQueue.offer(event, 100, TimeUnit.MILLISECONDS)) {
                     ret = true;
                 }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ret;
        }
    }

    public class Consumer {
        public void consume() {
            Thread thread = new Thread(() -> {
                while(true) {
                    try {
                        Event event = blockingQueue.take();
                        System.out.println("dealing with event: " + event.eventCtx);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
