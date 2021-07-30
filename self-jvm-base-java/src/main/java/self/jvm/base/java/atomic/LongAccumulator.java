package self.jvm.base.java.atomic;

/**
 * LongAccumulator
 *
 * @author chenzb
 * @date 2021/7/27
 */
public class LongAccumulator {

    public static void main(String[] args) {
        java.util.concurrent.atomic.LongAccumulator longAccumulator = new java.util.concurrent.atomic.LongAccumulator((x, y) -> x * y, 2);
        longAccumulator.accumulate(2);
        System.out.println(longAccumulator);
    }

    // todo 未实现， 内部依赖分段锁
}
