package jvmparse;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * ExampleClass
 *
 * @author chenzb
 * @date 2019/11/4
 */
public class ExampleClass implements Lock {

    static int i = 0;
    static Integer I = 0;
    @Deprecated
    static final float f = 1.0f;
    static final Float F = 1.0f;
    double d = 1.0;

    String s = "str";

    volatile int t;

    public void test() {
        t = 1;
        System.out.println(t);
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
