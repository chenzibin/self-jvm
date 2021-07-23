package self.jvm.base.java.cas;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * UnsafeDemo
 *
 * @author chenzb
 * @date 2020/3/4
 */
public class UnsafeUtil {

    public static void main(String[] args) {
        layout(AtomicIntegerArray.class);
    }

    public static void layout(Class clazz) {
        System.out.println(VM.current().details());
        ClassLayout classLayout = ClassLayout.parseClass(clazz);
        System.out.println(classLayout.toPrintable());
    }

    public static Unsafe getUnsafeInstance() {
        // 通过反射获取rt.jar下的Unsafe类
        try {
            Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeInstance.setAccessible(true);
            return (Unsafe) theUnsafeInstance.get(Unsafe.class);
        } catch (Exception e) {
            throw new SecurityException("Unsafe");
        }
    }
}
