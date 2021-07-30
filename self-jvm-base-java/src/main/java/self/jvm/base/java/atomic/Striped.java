package self.jvm.base.java.atomic;

import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.LongBinaryOperator;

/**
 * Striped
 *
 * @author chenzb
 * @date 2021/7/27
 */
public class Striped {

    @sun.misc.Contended
    static class Cell {
        private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
        private static final long valueOffset;
        volatile long value;

        static {
            try {
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (NoSuchFieldException e) {
                throw new Error(e);
            }
        }

        boolean cas(long expect, long update) {
            return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
        }
    }

    transient volatile long base;
    transient volatile Cell[] cells;

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private static final long baseOffset;
    private static final long probeOffset;
    static {
        try {
            baseOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("base"));
            probeOffset = unsafe.objectFieldOffset(Thread.class.getDeclaredField("threadLocalRandomProbe"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    boolean casBase(long expect, long update) {
        return unsafe.compareAndSwapLong(this, baseOffset, expect, update);
    }

    static int getProbe() {
        return unsafe.getInt(Thread.currentThread(), probeOffset);
    }

    void longAccumulate(long value, LongBinaryOperator fn,
                              boolean wasUncontended) {
        int h;
        if ((h = getProbe()) == 0) {
            ThreadLocalRandom.current(); // force initialization
            h = getProbe();
            wasUncontended = true;
        }
    }
}
