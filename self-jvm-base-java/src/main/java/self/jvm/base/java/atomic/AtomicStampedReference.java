package self.jvm.base.java.atomic;

import lombok.AllArgsConstructor;
import lombok.ToString;
import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

/**
 * AtomicStampedReference
 *
 * @author chenzb
 * @date 2021/7/23
 */
public class AtomicStampedReference<T> {

    public static void main(String[] args) {
        TestObject testObject = new TestObject("a", 1);
        AtomicStampedReference<TestObject> atomicStampedReference = new AtomicStampedReference<>(testObject, testObject.version);
        TestObject update = new TestObject("b", 3);
        atomicStampedReference.compareAndSet(testObject, update, testObject.version, update.version);
        System.out.println(atomicStampedReference.getReference());
    }

    @AllArgsConstructor
    @ToString
    public static class TestObject {
        private String value;
        private int version;
    }

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private static final long pairOffset;
    private volatile Pair<T> pair;

    static {
        try {
            pairOffset = unsafe.objectFieldOffset(AtomicStampedReference.class.getDeclaredField("pair"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public class Pair<T> {
        private volatile T value;
        private volatile int version;

        public Pair(T value, int version) {
            this.value = value;
            this.version = version;
        }
    }

    public AtomicStampedReference(T value, int version) {
        this.pair = new Pair<>(value, version);
    }


    private boolean compareAndSet(T expect, T update, int expectVersion, int updateVersion) {
        return expect == pair.value && expectVersion == pair.version && unsafe.compareAndSwapObject(this, pairOffset, pair, new Pair<>(update, updateVersion));
    }

    public T getReference() {
        return pair.value;
    }
}
