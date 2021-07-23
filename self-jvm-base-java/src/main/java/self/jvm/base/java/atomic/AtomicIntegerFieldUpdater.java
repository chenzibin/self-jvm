package self.jvm.base.java.atomic;

import self.jvm.base.java.cas.UnsafeUtil;
import sun.misc.Unsafe;

/**
 * AtomicIntegerFieldUpdater
 *
 * @author chenzb
 * @date 2021/7/21
 */
public class AtomicIntegerFieldUpdater<T> {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<IntObject> fieldUpdater = new AtomicIntegerFieldUpdater<>(IntObject.class, "value");
        IntObject intObject = new IntObject();
        fieldUpdater.compareAndSet(intObject, 0, 1);
        System.out.println(intObject.value);
    }

    public static class IntObject {
        private volatile int value;
    }

    private static final Unsafe unsafe = UnsafeUtil.getUnsafeInstance();
    private long offset;
    private Class tClass;
    private String fieldName;

    public AtomicIntegerFieldUpdater(Class tClass, String fieldName) {
        this.tClass = tClass;
        this.fieldName = fieldName;
        try {
            // jdk源码中额外处理不同目录权限的类，不同类加载器加载类等问题
            offset = unsafe.objectFieldOffset(tClass.getDeclaredField(fieldName));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void compareAndSet(T obj, int expect, int update) {
        unsafe.compareAndSwapInt(obj, offset, expect, update);
    }
}
