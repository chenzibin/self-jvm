package self.jvm.base.java.struct.map;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;

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
