package self.jvm.base.java.lock;

import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportTest
 *
 * @author chenzb
 * @date 2021/7/29
 */
public class LockSupportTest {

    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("before");
            LockSupport.park();
            System.out.println("after");
            System.out.println("inner " + Thread.interrupted());
        }, "support");
        thread.start();
        Thread.sleep(1000);
        System.out.println("....");
//        LockSupport.unpark(thread);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        new Scanner(System.in).next();
    }
}
