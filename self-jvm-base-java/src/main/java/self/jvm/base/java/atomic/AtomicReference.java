package self.jvm.base.java.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

import java.util.HashMap;
import java.util.Map;

/**
 * AtomicReference
 *
 * @author chenzb
 * @date 2021/7/23
 */
public class AtomicReference<T> {

    public static void main(String[] args) {
        TestObject testObject = new TestObject("a");
        AtomicReference<TestObject> atomicReference = new AtomicReference<>(testObject);
        TestObject udpate = new TestObject("b");
        atomicReference.compareAndSet(testObject, udpate);
        System.out.println(atomicReference);
    }

    @AllArgsConstructor
    @ToString
    public static class TestObject {
        private String value;
    }

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private static final long valueOffset;
    private volatile T value;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicReference.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public AtomicReference(T value) {
        this.value = value;
    }

    private void compareAndSet(T expect, T update) {
        unsafe.compareAndSwapObject(this, valueOffset, expect, update);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
