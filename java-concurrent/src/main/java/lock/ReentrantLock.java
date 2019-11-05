package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * ReentrantLock
 *
 * @author chenzb
 * @date 2019/10/16
 */
public class ReentrantLock implements Lock {

    class Node {

    }

    interface Sync {

        /**
         * 加锁
         */
        void lock();

        /**
         * 释放锁
         * @param arg 释放锁数量
         */
        void release(int arg);
    }

    class NonfairSync implements Sync {

        @Override
        public void lock() {

        }

        @Override
        public void release(int arg) {

        }
    }

    class FairSync implements Sync {

        private volatile int state;

        private Node head;

        private Node tail;

        @Override
        public void lock() {
            Thread current = Thread.currentThread();
            if (state == 0) {
                // 锁未被占用， 可尝试获取，由于当前位置存在竞争
                if (true) {

                }
            }
        }

        @Override
        public void release(int arg) {

        }

    }

    private Sync sync;

    public ReentrantLock() {
        this.sync = new NonfairSync();
    }

    public ReentrantLock(boolean fair) {
        this.sync = fair ? new FairSync() : new NonfairSync();
    }

    @Override
    public void lock() {
        sync.lock();
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
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }


}
