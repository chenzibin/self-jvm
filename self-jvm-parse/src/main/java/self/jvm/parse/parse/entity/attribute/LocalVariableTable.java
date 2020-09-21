package self.jvm.parse.parse.entity.attribute;

import self.jvm.parse.parse.ClassBuffer;
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
public class LocalVariableTable extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   local_variable_table_length
     * {
     *     u2   start_pc
     *     u2   length
     *     u2   name_index
     *     u2   descriptor_index
     *     u2   index
     * } local_variable_table[local_variable_table_length]
     */
    private int localVariableTableLength;
    private List<LocalVariable> lineNumberTable;

    public LocalVariableTable(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.localVariableTableLength = buffer.u2();
        this.lineNumberTable = IntStream.range(0, this.localVariableTableLength)
                .mapToObj(i -> new LocalVariable(buffer))
                .collect(Collectors.toList());
    }

    @Data
    class LocalVariable {
        private int startPc;
        private int length;
        private int nameIndex;
        private int descriptorIndex;
        private int index;

        public LocalVariable(ClassBuffer buffer) {
            this.startPc = buffer.u2();
            this.length = buffer.u2();
            this.nameIndex = buffer.u2();
            this.descriptorIndex = buffer.u2();
            this.index = buffer.u2();
        }
    }
}
