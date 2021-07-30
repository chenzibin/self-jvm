package self.jvm.base.java.atomic;

/**
 * LongAdder
 *
 * @author chenzb
 * @date 2021/7/26
 */
public class LongAdder extends Striped {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        System.out.println(longAdder);
    }

    private void add(int value) {
        if (cells == null && casBase(base, base + value)) {
            return;
        }
        if (cells == null || cells.length == 0) {
            longAccumulate(value, null, true);
            return;
        }
        Cell cell = cells[getProbe() & (cells.length - 1)];
        if (cell != null && !cell.cas(cell.value, cell.value + value)) {
            longAccumulate(value, null, false);
            return;
        }
        longAccumulate(value, null, true);
    }
}
