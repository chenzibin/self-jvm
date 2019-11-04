package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * DoubleConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class DoubleInfo extends LongInfo {
    public DoubleInfo(ClassBuffer buffer, int tag) {
        super(buffer, tag);
    }
}
