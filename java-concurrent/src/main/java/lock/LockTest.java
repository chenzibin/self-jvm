package lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * LockTest
 *
 * @author chenzb
 * @date 2019/9/19
 */
public class LockTest {

    ReentrantLock lock = new ReentrantLock();

    @Test
    public void testAcquireLock() throws Exception {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(this::out);
        singleThreadPool.execute(this::out);
        singleThreadPool.execute(this::out);

//        new Thread(this::out).start();
//        new Thread(this::out).start();
//        new Thread(this::out).start();
//        singleThreadPool.execute(this::out);
//        singleThreadPool.execute(this::out);

        System.in.read();
        singleThreadPool.shutdown();
    }

    public void out() {
        lock.lock();
        printValue("hold_count", lock.getHoldCount());
        printValue("queue_length", lock.getQueueLength());
        reflect();
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    void printValue(String key, Object value) {
        System.out.println(String.format("%s: %s", key, value));
    }

    @Test
    public void reflect() {
        Class clazz = ReentrantLock.class;
        Field[] fields = clazz.getDeclaredFields();
        Stream.of(fields).forEach(field -> {
            try {
                field.setAccessible(true);
                Object obj = field.get(lock);
//                System.out.println(JSONObject.toJSON(obj));
//                System.out.println(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }
}
