package self.jvm.base.java.lock;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockTest
 *
 * @author chenzb
 * @date 2021/7/29
 */
public class ReentrantLockTest {

    @Test
    public void test() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        async("signal", () -> {
            try {
                lock.lock();
                Thread.sleep(100000);
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(1000);
        Thread wait = async("wait", lock::lock);
        Thread.sleep(1000);
        wait.interrupt();
        new Scanner(System.in).next();
    }

    private Thread async(String name, Runnable runnable) {
        Thread thread = new Thread(runnable, name);
        thread.start();
        return thread;
    }
}
