package self.jvm.base.java.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * ReentrantLock
 *
 * @author chenzb
 * @date 2021/7/29
 */
public class ReentrantLock implements Lock {

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

    abstract class Sync extends AbstractQueuedSynchronizer {

    }

    class FairSync extends Sync {

    }

    class NonFairSync extends Sync {

    }
}
