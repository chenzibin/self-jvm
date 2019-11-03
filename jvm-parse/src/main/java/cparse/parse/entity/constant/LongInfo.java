package cparse.parse.entity.constant;

import cparse.parse.ClassBuffer;

/**
 * LongConstant
 *
 * @author chenzb
 * @date 2019/11/1
 */
public class LongInfo extends Constant {

    /**
     * u1   tag             Long: 5, Double: 6
     * u4   high_bytes      高位4字节
     * u4   low_bytes       低位4字节
     */
    private int highBytes;
    private int lowBytes;

    public LongInfo(ClassBuffer buffer, int tag) {
        super(tag);
        highBytes = buffer.u4();
        lowBytes = buffer.u4();
    }
}
