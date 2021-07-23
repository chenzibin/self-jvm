package self.jvm.base.java.atomic;

import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

/**
 * AtomicInteger
 *
 * @author chenzb
 * @date 2021/7/21
 */
public class AtomicInteger {

    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger();
        value.compareAndSet(0, 1);
        System.out.println(value);
    }

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    private volatile int value;

    private void compareAndSet(int expect, int update) {
        unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
