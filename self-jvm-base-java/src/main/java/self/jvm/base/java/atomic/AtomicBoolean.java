package self.jvm.base.java.atomic;

import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

/**
 * AtomicLong
 *
 * @author chenzb
 * @date 2021/7/23
 */
public class AtomicBoolean {

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.compareAndSet(false, true);
        System.out.println(atomicBoolean);
    }

    private void compareAndSet(boolean expect, boolean update) {
        unsafe.compareAndSwapInt(this, valueOffset, expect ? 1 : 0, update ? 1 : 0);
    }

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private static final long valueOffset;
    private volatile int value;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicBoolean.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    @Override
    public String toString() {
        return value == 1 ? "true" : "false";
    }
}
