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
public class Exceptions extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   number_of_exceptions
     * u2   exception_index_table[number_of_exceptions]
     */
    private int numberOfExceptions;
    private List<Integer> exceptionIndexTable;

    public Exceptions(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.numberOfExceptions = buffer.u2();
        this.exceptionIndexTable = IntStream.range(0, this.numberOfExceptions)
                .mapToObj(i -> buffer.u2())
                .collect(Collectors.toList());
    }
}
