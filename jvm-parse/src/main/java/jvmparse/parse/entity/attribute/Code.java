package jvmparse.parse.entity.attribute;

import jvmparse.parse.ClassBuffer;
import jvmparse.parse.entity.ConstantPool;
import jvmparse.parse.entity.instruction.Instruction;
import jvmparse.parse.factory.AttributeFactory;
import jvmparse.parse.factory.InstructionFactory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    private List<Instruction> code;
    private int exceptionTableLength;
    private List<Exception> exceptionTable;
    private int attributesCount;
    private List<Attribute> attributeInfo;

    public Code(ClassBuffer buffer, int attributeNameIndex, ConstantPool constantPool) {
        super(buffer, attributeNameIndex);
        this.maxStack = buffer.u2();
        this.maxLocals = buffer.u2();
        this.codeLength = buffer.u4();
        InstructionFactory instructionFactory = new InstructionFactory();
        this.code = new ArrayList<>();
        int offset = buffer.getOffset() + codeLength;
        while (buffer.getOffset() < offset) {
            code.add(instructionFactory.getInstruction(buffer));
        }
        this.exceptionTableLength = buffer.u2();
        this.exceptionTable = IntStream.range(0, this.exceptionTableLength)
                .mapToObj(i -> new Exception(buffer))
                .collect(Collectors.toList());
        this.attributesCount = buffer.u2();
        AttributeFactory attributeFactory = new AttributeFactory();
        this.attributeInfo = IntStream.range(0, this.attributesCount)
                .mapToObj(i -> attributeFactory.getAttribute(buffer, constantPool))
                .filter(attribute -> !Objects.isNull(attribute))
                .collect(Collectors.toList());
    }

    @Data
    class Exception {

        /**
         * u2  start_pc
         * u2  end_pc
         * u2  handler_pc
         * u2  catch_type
         */
        private int startPc;
        private int endPc;
        private int handlerPc;
        private int catchType;

        public Exception(ClassBuffer buffer) {
            this.startPc = buffer.u2();
            this.endPc = buffer.u2();
            this.handlerPc = buffer.u2();
            this.catchType = buffer.u2();
        }
    }

}
