package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * InvokeDynamic
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class InvokeDynamic extends Constant {

    /**
     * u1   tag                             18
     * u2   bootstrap_method_attr_index     引导方法
     * u2   name_and_type_index             方法名和方法描述符
     */
    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    public InvokeDynamic(ClassBuffer buffer, int tag) {
        super(tag);
        this.bootstrapMethodAttrIndex = buffer.u2();
        this.nameAndTypeIndex = buffer.u2();
    }
}
