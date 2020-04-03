package cas;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * UnsafeDemo
 *
 * @author chenzb
 * @date 2020/3/4
 */
public class UnsafeDemo {

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        ClassLayout classLayout = ClassLayout.parseClass(HashMap.class);
        System.out.println(classLayout.toPrintable());
    }

    public static Unsafe getUnsafeInstance() throws Exception {
        // 通过反射获取rt.jar下的Unsafe类
        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        return (Unsafe) theUnsafeInstance.get(Unsafe.class);
    }
}
