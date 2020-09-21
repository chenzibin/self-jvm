package self.jvm.parse.parse.entity.constant;

import self.jvm.parse.parse.ClassBuffer;
import lombok.Data;

/**
 * Ref
 *
 * @author chenzb
 * @date 2019/11/1
 */
@Data
public class RefInfo extends Constant {

    /**
     * u1   tag                     field: 9 | method: 10 | interface_method : 11
     * u2   class_index             表示当前字段或方法是这个类或接口的成员
     * u2   name_and_type_index     名字和描述符
     */
    private int classIndex;
    private int nameAndTypeIndex;

    public RefInfo(ClassBuffer buffer, int tag) {
        super(tag);
        this.classIndex = buffer.u2();
        this.nameAndTypeIndex = buffer.u2();
    }

}
