package cparse.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassBuffer
 *
 * @author chenzb
 * @date 2019/10/30
 */
public class ClassBuffer {

    private byte[] buf;
    private int offset;

    public ClassBuffer(String classPath) {
        File file = new File(classPath);
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            this.buf = buffer;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int u4() {
        int i = Byte.toUnsignedInt(buf[offset]) << 24;
        i += Byte.toUnsignedInt(buf[1 + offset]) << 16;
        i += Byte.toUnsignedInt(buf[2 + offset]) << 8;
        i += Byte.toUnsignedInt(buf[3 + offset]);
        offset += 4;
        return i;
    }

    public int u2() {
        int i = Byte.toUnsignedInt(buf[offset]) << 8;
        i += Byte.toUnsignedInt(buf[1 + offset]);
        offset += 2;
        return i;
    }

    public int u1() {
        int i = Byte.toUnsignedInt(buf[offset]);
        offset += 1;
        return i;
    }
}
