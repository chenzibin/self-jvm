package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;
import lombok.ToString;

/**
 * Utf8
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
@ToString(callSuper = true)
public class Utf8 extends Constant {

    /**
     * u1   tag                     1
     * u2   length                  byte数组长度
     * u1   bytes[length]           字符串值的byte数组
     */
    private int length;
    private byte[] bytes;

    public Utf8(ClassBuffer buffer, int tag) {
        super(tag);
        this.length = buffer.u2();
        bytes = buffer.bytes(this.length);
    }

    public String getBytes() {
        return new String(bytes);
    }
}
