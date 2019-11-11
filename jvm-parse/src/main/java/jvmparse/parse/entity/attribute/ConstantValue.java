package jvmparse.parse.entity.attribute;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * ConstantValue
 *
 * @author chenzb
 * @date 2019/11/11
 */
@Data
public class ConstantValue extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   constant_value_index
     */
    private int constantValueIndex;

    public ConstantValue(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.constantValueIndex = buffer.u2();
    }
}
