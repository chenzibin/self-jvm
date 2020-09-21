package self.jvm.parse.parse;

import com.alibaba.fastjson.annotation.JSONType;
import self.jvm.parse.parse.entity.ConstantPool;
import self.jvm.parse.parse.entity.FieldInfo;
import self.jvm.parse.parse.entity.MethodInfo;
import self.jvm.parse.parse.entity.attribute.Attribute;
import self.jvm.parse.parse.factory.AttributeFactory;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ClassStruct
 *
 * @author chenzb
 * @date 2019/10/30
 */
@Data
@JSONType(orders = {"magic", "minorVersion", "majorVersion", "constantPoolCount", "constantPool", "accessFlags", "thisClass", "superClass", "interfacesCount", "interfaces", "fieldsCount", "fields", "methodsCount", "methods", "attributesCount", "attributes"})
public class ClassFormat {

    /**
     * u4               magic
     * u2               minor_version
     * u2               major_version
     * u2               constant_pool_count
     * cp_info          constant_pool[constant_pool_count-1]
     * u2               access_flags
     * u2               this_class
     * u2               super_class
     * u2               interfaces_count;
     * u2               interfaces[interfaces_count]
     * u2               fields_count
     * field_info       fields[fields_count]
     * u2               methods_count
     * method_info      methods[methods_count]
     * u2               attributes_count
     * attribute_info   attributes[attributes_count]
     */
    private String magic;
    private int minorVersion;
    private int majorVersion;

    private int constantPoolCount;
    private ConstantPool constantPool;

    private int accessFlags;
    private int thisClass;
    private int superClass;

    private int interfacesCount;
    private List<Integer> interfaces;

    private int fieldsCount;
    private List<FieldInfo> fields;

    private int methodsCount;
    private List<MethodInfo> methods;

    private int attributesCount;
    private List<Attribute> attributes;

    public ClassFormat(ClassBuffer buffer) {
        this.magic = magic(buffer);
        this.minorVersion = minorVersion(buffer);
        this.majorVersion = majorVersion(buffer);

        this.constantPoolCount = buffer.u2();
        this.constantPool = new ConstantPool(buffer, this.constantPoolCount);

        this.accessFlags = accessFlags(buffer);
        this.thisClass = thisClass(buffer);
        this.superClass = superClass(buffer);

        this.interfacesCount = buffer.u2();
        this.interfaces = IntStream.range(0, this.interfacesCount).mapToObj(i -> buffer.u2()).collect(Collectors.toList());

        this.fieldsCount = buffer.u2();
        this.fields = IntStream.range(0, this.fieldsCount).mapToObj(i -> new FieldInfo(buffer, this.constantPool)).collect(Collectors.toList());

        this.methodsCount = buffer.u2();
        this.methods = IntStream.range(0, this.methodsCount).mapToObj(i -> new MethodInfo(buffer, this.constantPool)).collect(Collectors.toList());

        AttributeFactory factory = new AttributeFactory();
        this.attributesCount = buffer.u2();
        this.attributes = IntStream.range(0, this.attributesCount).mapToObj(i -> factory.getAttribute(buffer, this.constantPool)).collect(Collectors.toList());
    }

    private String magic(ClassBuffer buffer) {
        int magic = buffer.u4();
        return Integer.toHexString(magic).toUpperCase();
    }

    private int minorVersion(ClassBuffer buffer) {
        return buffer.u2();
    }

    private int majorVersion(ClassBuffer buffer) {
        return buffer.u2();
    }

    private int accessFlags(ClassBuffer buffer) {
        return buffer.u2();
    }

    private int thisClass(ClassBuffer buffer) {
        return buffer.u2();
    }

    private int superClass(ClassBuffer buffer) {
        return buffer.u2();
    }

}
