package jvmparse.parse.entity.attribute;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

import java.util.List;

/**
 * ConstantValue
 *
 * @author chenzb
 * @date 2019/11/11
 */
@Data
public class LineNumberTable extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   line_number_table_length
     * {
     *     u2   start_pc
     *     u2   line_number
     * } line_number_table[line_number_table_length]
     */
    private int constantValueIndex;
    private int lineNumberTableLength;
    private List<LineNumber> lineNumberTable;

    public LineNumberTable(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.constantValueIndex = buffer.u2();
        this.lineNumberTableLength = buffer.u2();

    }

    class LineNumber {
        private int startPc;
        private int lineNumber;

        public LineNumber(ClassBuffer buffer) {
            this.startPc = buffer.u2();
            this.lineNumber = buffer.u2();
        }
    }
}
