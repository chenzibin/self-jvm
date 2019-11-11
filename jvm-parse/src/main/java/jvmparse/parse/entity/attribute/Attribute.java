package jvmparse.parse.entity.attribute;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * Attribute
 *
 * @author chenzb
 * @date 2019/11/11
 */
@Data
public class Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u1   info[attribute_length]
     */
    private int attributeNameIndex;
    private int attributeLength;

    public Attribute(ClassBuffer buffer, int attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = buffer.u4();
    }
}
