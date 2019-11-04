package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * MethodTypeConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class MethodTypeInfo extends Constant {

    /**
     * u1   tag                     16
     * u2   descriptor_index        方法的描述符
     */
    private int descriptorIndex;

    public MethodTypeInfo(ClassBuffer buffer, int tag) {
        super(tag);
        this.descriptorIndex = buffer.u2();
    }
}
