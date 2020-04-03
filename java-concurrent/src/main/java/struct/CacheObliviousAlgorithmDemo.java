package struct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * CacheObliviousAlgorithmTest
 *
 * @author chenzb
 * @date 2020/3/9
 */
public class CacheObliviousAlgorithmDemo {

    public static final long START_TIME = System.currentTimeMillis();

    public static void main(String[] args) {
        String index = "uyun_application_{yyyy.MM.dd}";
        int isPartition = index.indexOf("{");

        String format = index.substring(isPartition + 1, index.indexOf("}"));
        String field = index.substring(index.indexOf(",") + 1);
        System.out.println(format);
        System.out.println(field);
    }

    public static List link() {
        return new LinkedList();
    }

    public static List array() {
        return new ArrayList();
    }

    public static void poll(List list) {
        IntStream.range(0, 99999999).forEach(list::add);
    }

    public static void each(List list) {
        for (Object i : list) {
            i = 129;
        }
    }

    public static void time() {
        long second = (System.currentTimeMillis() - START_TIME) / 1000;
        System.out.println(second);
    }
}
