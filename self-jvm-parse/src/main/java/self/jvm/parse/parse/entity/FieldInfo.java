package self.jvm.parse.parse.entity;

import self.jvm.parse.parse.ClassBuffer;
import self.jvm.parse.parse.entity.attribute.Attribute;
import self.jvm.parse.parse.factory.AttributeFactory;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FieldInfo
 *
 * @author chenzb
 * @date 2019/11/4
 */
@Data
public class FieldInfo {

    /**
     * u2               access_flags
     * u2               name_index
     * u2               descriptor_index
     * u2               attributes_count
     * attribute_info   attributes[attributes_count]
     */
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private int attributesCount;
    private List<Attribute> attributeInfo;

    public FieldInfo(ClassBuffer buffer, ConstantPool constantPool) {
        this.accessFlags = buffer.u2();
        this.nameIndex = buffer.u2();
        this.descriptorIndex = buffer.u2();
        this.attributesCount = buffer.u2();
        AttributeFactory factory = new AttributeFactory();
        this.attributeInfo = IntStream.range(0, this.attributesCount)
                .mapToObj(i -> factory.getAttribute(buffer, constantPool))
                .filter(attribute -> !Objects.isNull(attribute))
                .collect(Collectors.toList());
    }
}
