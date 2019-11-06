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

        /**
         * 独占线程的同步性由state保证
         * 两种情况下：
         * 1、state==0, 表示当前资源未加锁
         * 2、state!=0 && Thread.currentThread()==exclusiveOwnerThread, 对于每个线程来说，setState、 setExclusiveOwnerThread、getState、getExclusiveOwnerThread 是顺序执行的，
         *      即不存在state!=0(锁被占有), 但对于当前线程来说，缓存中exclusiveOwnerThread是当前线程，但内存中该值不是当前线程的情况
         */
        private Thread exclusiveOwnerThread;

        private Node head;

        private Node tail;

        @Override
        public void lock() {
            Thread current = Thread.currentThread();
            if (state == 0) {
                /**
                 *  锁未被占用， 可尝试获取，由于当前位置存在竞争
                 *  若获取到锁， 更新state, 更有独占线程
                 *  若未获取到锁， 中断线程
                 */
                if (true) {
                    Node t = tail;
                    Node h = head;
                    Node s;
                    h != t && ((s = h.next) == null || s.thread != Thread.currentThread());

                    current.interrupt();
                }
            } else if (current == exclusiveOwnerThread) {
                /**
                 *  锁已被当前线程占用, 重入锁，更新state
                 */
                state++;

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
