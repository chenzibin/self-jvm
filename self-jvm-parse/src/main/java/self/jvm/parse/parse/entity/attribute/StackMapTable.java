package self.jvm.parse.parse.entity.attribute;

import self.jvm.parse.parse.ClassBuffer;
import lombok.Data;

/**
 * ConstantValue
 *
 * @author chenzb
 * @date 2019/11/11
 */
@Data
public class StackMapTable extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   constant_value_index
     */
    private int constantValueIndex;

    public StackMapTable(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.constantValueIndex = buffer.u2();
    }
}
