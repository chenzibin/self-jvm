package cparse.parse.entity.constant;

import cparse.parse.ClassBuffer;

/**
 * Clazz
 *
 * @author chenzb
 * @date 2019/11/1
 */
public class ClassInfo extends Constant {

    /**
     * u1   tag                     7
     * u2   name_index              类或接口的描述符
     */
    private int nameIndex;

    public ClassInfo(ClassBuffer buffer, int tag) {
        super(tag);
        this.nameIndex = buffer.u2();
    }
}
