package self.jvm.parse.parse.entity.constant;

import self.jvm.parse.parse.ClassBuffer;
import lombok.Data;

/**
 * FloatConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class FloatInfo extends IntegerInfo {
    public FloatInfo(ClassBuffer buffer, int tag) {
        super(buffer, tag);
    }
}
