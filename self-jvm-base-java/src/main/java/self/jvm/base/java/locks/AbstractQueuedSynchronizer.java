package self.jvm.base.java.locks;

/**
 * AbstractQueuedSynchronizer
 *
 * @author chenzb
 * @date 2021/7/29
 */
public abstract class AbstractQueuedSynchronizer {

    class Node {
        Node prev;
        Node next;
    }
}
