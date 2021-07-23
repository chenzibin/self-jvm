package self.jvm.base.java.atomic;

import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

import java.util.Arrays;

/**
 * AtomicIntegerArray
 *
 * @author chenzb
 * @date 2021/7/23
 */
public class AtomicIntegerArray {

    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(2);
        atomicIntegerArray.compareAndSet(1, 0, 1);
        System.out.println(atomicIntegerArray);
    }

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private static final long arrayBaseOffset = unsafe.arrayBaseOffset(int[].class);
    private int[] values;

    public AtomicIntegerArray(int length) {
        values = new int[length];
    }

    public boolean compareAndSet(int index, int expect, int update) {
        return unsafe.compareAndSwapInt(values, arrayBaseOffset + (index << 2), expect, update);
    }

    @Override
    public String toString() {
        return "AtomicIntegerArray{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
