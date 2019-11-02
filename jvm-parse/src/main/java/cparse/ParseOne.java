package cparse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * ParseOne
 *
 * @author chenzb
 * @date 2019/10/25
 */
public class ParseOne {

    public static void main(String[] args) throws IOException {
        String classPath = "F:\\learn\\udap-test\\target\\classes\\sync\\SyncTest.class";
        File file = new File(classPath);
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
//            byte[] buf = getBytes(buffer, 0, 4);
//            printByte(buf);
            int magic = getMagic(buffer, 0);
            System.out.println(Integer.toBinaryString(magic));
            System.out.println(Integer.toHexString(magic).toUpperCase());

            int minor = getMinor(buffer, 4);
            System.out.println(minor);

            int major = getMinor(buffer, 6);
            System.out.println(major);
        }

    }

    public static byte[] getBytes(byte[] buffer, int from, int size) {
        byte[] buf = new byte[size];
        for (int i = 0; i < size; i++) {
            buf[i] = buffer[i + from];
            System.out.println(Byte.toUnsignedInt(buf[i]));
        }
        return buf;
    }

    public static int getMagic(byte[] buffer, int from) {
        byte[] buf = new byte[4];
        for (int i = 0; i < 4; i++) {
            buf[i] = buffer[i + from];
        }
        int i = Byte.toUnsignedInt(buf[0]) << 24;
        i += Byte.toUnsignedInt(buf[1]) << 16;
        i += Byte.toUnsignedInt(buf[2]) << 8;
        i += Byte.toUnsignedInt(buf[3]);

        return i;
    }

    public static int getMinor(byte[] buffer, int from) {
        byte[] buf = new byte[2];
        for (int i = 0; i < 2; i++) {
            buf[i] = buffer[i + from];
        }
        int i = Byte.toUnsignedInt(buf[0]) << 8;
        i += Byte.toUnsignedInt(buf[1]);

        return i;
    }

    public static void printByte(byte[] buffer) throws UnsupportedEncodingException {
        System.out.println(new String(buffer, "utf8"));
    }
}
