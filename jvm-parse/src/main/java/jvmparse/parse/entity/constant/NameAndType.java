package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * NameAndType
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class NameAndType extends Constant {

    /**
     * u1   tag                     12
     * u2   name_index              特殊：<init> or 有效的字段或方法的非全限定名
     * u2   descriptor_index        有效的字段描述符或方法描述符
     */
    private int nameIndex;
    private int descriptorIndex;

    public NameAndType(ClassBuffer buffer, int tag) {
        super(tag);
        this.nameIndex = buffer.u2();
        this.descriptorIndex = buffer.u2();
    }
}
