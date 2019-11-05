package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * CLHLock
 *
 * @author chenzb
 * @date 2019/10/10
 */
public class CLHLock implements Lock {

    private class CLHNode {
        private boolean active = true;
    }

    private ThreadLocal<CLHNode> currentThread = new ThreadLocal<>();

    private volatile CLHNode tail;

    private AtomicReferenceFieldUpdater<CLHLock, CLHNode> updater = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");

    @Override
    public void lock() {
        CLHNode cNode = currentThread.get();

        if (cNode == null) {
            cNode = new CLHNode();
            currentThread.set(cNode);
        }

        CLHNode predecessor = updater.getAndSet(this, cNode);
        if (tail != null) {
            while (predecessor.active) {
                // 自旋等待，前置节点有效状态为false
            }
        }
    }

    @Override
    public void unlock() {
        CLHNode cNode = currentThread.get();

        if (cNode == null || !cNode.active) {
            return;
        }

        currentThread.remove();

        if (!updater.compareAndSet(this, cNode, null)) {
            cNode.active = false;
        }
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

        final CLHLock lock = new CLHLock();

        for (int i = 1; i <= 10; i++) {
            new Thread(generateTask(lock, String.valueOf(i))).start();
        }

    }

    private static Runnable generateTask(final CLHLock lock, final String taskId) {
        return () -> {
            lock.lock();

            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }

            System.out.println(String.format("Thread %s Completed", taskId));
            lock.unlock();
        };
    }
}
