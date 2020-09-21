package self.jvm.parse.parse.entity.constant;

import self.jvm.parse.parse.ClassBuffer;
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
