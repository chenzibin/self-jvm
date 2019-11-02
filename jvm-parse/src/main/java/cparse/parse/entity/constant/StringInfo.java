package cparse.parse.entity.constant;

import cparse.parse.ClassBuffer;

/**
 * StringConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
public class StringInfo extends Constant {

    /**
     * u1   tag                     7
     * u2   string_index            utf8字符串
     */
    private int stringIndex;

    public StringInfo(ClassBuffer buffer, int tag) {
        super(tag);
        this.stringIndex = buffer.u2();
    }
}
