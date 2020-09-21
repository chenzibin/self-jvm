package self.jvm.parse.parse.entity.constant;

import self.jvm.parse.parse.ClassBuffer;
import lombok.Data;

/**
 * IntegerConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class IntegerInfo extends Constant {

    /**
     * u1   tag              Integer: 3, Float: 4
     * u4   bytes            4字节
     */
    private int bytes;

    public IntegerInfo(ClassBuffer buffer, int tag) {
        super(tag);
        this.bytes = buffer.u4();
    }

}
