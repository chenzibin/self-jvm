package jvmparse.parse.entity.constant;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * MethodHandleConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class MethodHandleInfo extends Constant {

    /**
     * u1   tag                     15
     * u2   reference_kind          方法句柄的类型（1~9）
     * u1   reference_index         1~4: FieldRef, 5~8: MethodRef, 9: 实例初始化方法
     */
    private int referenceKind;
    private int referenceIndex;

    public MethodHandleInfo(ClassBuffer buffer, int tag) {
        super(tag);
        this.referenceKind = buffer.u2();
        this.referenceIndex = buffer.u1();
    }
}
