package lock;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * MCSLock
 *
 * @author chenzb
 * @date 2019/10/8
 */
public class MCSLock implements Lock {

    @Data
    private class MCSNode {
        // 后继节点
        private MCSNode next;
        // 默认等待锁
        private volatile boolean blocked = true;
    }

    private ThreadLocal<MCSNode> currentThread = new ThreadLocal<>();

    volatile MCSNode tail;

    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> updater = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class, "tail");

    @Override
    public void lock() {
        MCSNode cNode = currentThread.get();

        if (cNode == null) {
            cNode = new MCSNode();
            currentThread.set(cNode);
        }

        MCSNode predecessor = updater.getAndSet(this, cNode);
        if (predecessor != null) {
            predecessor.setNext(cNode);
            while (cNode.blocked) {
                // 自旋等待，当前节点阻塞状态为false
            }
        } else {
            cNode.blocked = false;
        }
    }

    @Override
    public void unlock() {
        MCSNode cNode = currentThread.get();

        if (cNode == null || cNode.blocked) {
            return;
        }

        if (cNode.next == null && !updater.compareAndSet(this, cNode, null)) {
            while (cNode.next == null) {
                // 自旋等待，新节点加入链表
            }
        }

        if (cNode.next != null) {
            cNode.next.blocked = false;
            cNode.next = null;
        }

        currentThread.remove();
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
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {

        final MCSLock lock = new MCSLock();

        for (int i = 1; i <= 1; i++) {
            new Thread(generateTask(lock, String.valueOf(i))).start();
        }

    }

    private static Runnable generateTask(final MCSLock lock, final String taskId) {
        return () -> {
            lock.lock();
            try {
                Thread.sleep(1000);
                lock.lock();
            } catch (Exception e) {

            }

            System.out.println(String.format("Thread %s Completed", taskId));
            lock.unlock();
        };
    }

}
