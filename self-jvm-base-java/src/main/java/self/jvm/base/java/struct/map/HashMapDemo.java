package self.jvm.base.java.struct.map;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMapDemo
 *
 * @author chenzb
 * @date 2020/3/24
 */
public class HashMapDemo {

    @Test
    public void testSerialize() throws IOException, ClassNotFoundException {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "2");
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream output = new ObjectOutputStream(byteArrayOutputStream)) {
            output.writeObject(map);

            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                  ObjectInputStream input = new ObjectInputStream(byteArrayInputStream)) {
                HashMap mapSerial = (HashMap) input.readObject();
                System.out.println(mapSerial);
            }

        }
    }

    @Test
    public void testTableSize() {
        int cap = 8;
        System.out.println(tableSizeFor8(cap));
        System.out.println(tableSizeFor12(cap));
    }

    /**
     * 动态扩容
     *  当存储量超过阈值时，自动扩容为2倍
     *  阈值计算: threshold * loadFactor, default loadFactor: 0.75
     * 哈希冲突
     * hashcode: h
     */
    @Test
    public void testMyHashMap() {
        Map<String, String> map = new HashMap<>(2);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "3");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
    }


    int tableSizeFor8(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    int tableSizeFor12(int cap) {
        int n = cap - 1;
        n = -1 >>> (32 - Integer.toBinaryString(n).length());
        return n + 1;
    }
}
