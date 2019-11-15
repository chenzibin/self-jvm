package jvmparse.parse.entity.attribute;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * Code
 *
 * @author chenzb
 * @date 2019/11/11
 */
@Data
public class Code extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   max_stack
     * u2   max_locals
     * u4   code_length
     * u1   code[code_length]
     * u2   exception_table_length
     * {
     *      u2  start_pc
     *      u2  end_pc
     *      u2  handler_pc
     *      u2  catch_type
     * }    exception_table[exception_table_length]
     * u2   attributes_count
     * attribute_info   attributes[attributes_count]
     */
    private int maxStack;
    private int maxLocals;
    private int codeLength;

    public Code(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.maxStack = buffer.u2();
        this.maxLocals = buffer.u2();
        this.codeLength = buffer.u4();
    }
}
