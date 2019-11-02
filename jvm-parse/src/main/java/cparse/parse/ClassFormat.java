package cparse.parse;

import cparse.parse.entity.constant.Constant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassStruct
 *
 * @author chenzb
 * @date 2019/10/30
 */
@Data
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
    private List<Constant> constantPool;

    private int accessFlags;
    private int thisClass;
    private int superClass;

    private int interfacesCount;
    private List<Object> interfaces;

    private int fieldsCount;
    private List<Object> fields;

    private int methodsCount;
    private List<Object> methods;

    private int attributesCount;
    private List<Object> attributes;

    public ClassFormat(ClassBuffer buffer) {
        this.magic = magic(buffer);
        this.minorVersion = minorVersion(buffer);
        this.majorVersion = majorVersion(buffer);

        this.constantPoolCount = constantPoolCount(buffer);
        this.constantPool = new ArrayList<>(this.constantPoolCount - 1);

        ConstantFactory constantFactory = new ConstantFactory();
        for (int i = 0; i < this.constantPoolCount - 1; i++) {
            this.constantPool.add(constantFactory.getConstant(buffer));
        }
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

    private int constantPoolCount(ClassBuffer buffer) {
        return buffer.u2();
    }
}
