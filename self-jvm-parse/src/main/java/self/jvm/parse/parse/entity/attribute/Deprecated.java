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
public class Deprecated extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     */

    public Deprecated(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
    }
}
