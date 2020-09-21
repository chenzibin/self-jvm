package self.jvm.base.java.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
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
        Thread thread;

        Node prev;
        Node next;

        public Node() {
        }

        public Node(Thread thread) {
            this.thread = thread;
        }
    }

    interface Sync {

        /**
         * 加锁
         */
        void lock();

        /**
         * 获取锁
         * @param arg
         */
        void acquire(int arg);

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
        public void acquire(int arg) {

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

        AtomicReferenceFieldUpdater<FairSync, Integer> stateUpdater = AtomicReferenceFieldUpdater.newUpdater(FairSync.class, int.class, "state");
        AtomicReferenceFieldUpdater<FairSync, Node> tailUpdater = AtomicReferenceFieldUpdater.newUpdater(FairSync.class, Node.class, "tail");

        @Override
        public void lock() {
            acquire(1);
        }

        @Override
        public void acquire(int arg) {
            Thread current = Thread.currentThread();
            if (state == 0) {
                /*
                 *  锁未被占用， 对于公平锁，若无等待线程或等待线程第一个即当前线程，则可尝试获取
                 *  由于当前位置存在竞争
                 *  若获取到锁， 更新state, 更新独占线程
                 *  若未获取到锁， 中断线程
                 */
                //  队列为空  或者  在队列不空的情况下， 第一个等待线程即当前线程
                if (head == tail || (head.next != null && head.next.thread == current) ) {
                    if (stateUpdater.compareAndSet(this, 0, 1)) {
                        exclusiveOwnerThread = current;
                    }
                }
            } else if (current == exclusiveOwnerThread) {
                /*
                 *  锁已被当前线程占用, 重入锁，更新state
                 *  由于此时，不可能存在其他线程读写state，故state+=arg无需使用原子性操作
                 */
                state += arg;
            } else {
                /*
                 *  锁被其他线程占用，执行入队操作
                 *  队列的第一个节点必须是空节点
                 */
                Node node = new Node(current);
                Node t = tail;
                if (t == null) {
                    if (tailUpdater.compareAndSet(this, null, new Node())) {
                        // h!=t && h.next==null
                        head = tail;
                        t = tail;
                    }
                }
                if (tailUpdater.compareAndSet(this, tail, node)) {
                    // h!=t && h.next==null
                    node.prev = t;
                    t.next = node;
                }
            }
        }

        @Override
        public void release(int arg) {
            Thread current = Thread.currentThread();
            if (current != exclusiveOwnerThread) {
                throw new IllegalMonitorStateException();
            }
            int newState = state - arg;
            if (newState == 0) {
                exclusiveOwnerThread = null;
            }
            state = newState;
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
