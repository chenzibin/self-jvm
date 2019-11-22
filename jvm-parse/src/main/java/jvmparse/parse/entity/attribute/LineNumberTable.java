package jvmparse.parse.entity.attribute;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    private int lineNumberTableLength;
    private List<LineNumber> lineNumberTable;

    public LineNumberTable(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.lineNumberTableLength = buffer.u2();
        this.lineNumberTable = IntStream.range(0, this.lineNumberTableLength)
                .mapToObj(i -> new LineNumber(buffer))
                .collect(Collectors.toList());
    }

    @Data
    class LineNumber {
        private int startPc;
        private int lineNumber;

        public LineNumber(ClassBuffer buffer) {
            this.startPc = buffer.u2();
            this.lineNumber = buffer.u2();
        }
    }
}
