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
public class RuntimeVisibleAnnotations extends Attribute {

    /**
     * u2   attribute_name_index
     * u4   attribute_length
     * u2   num_annotations
     * annotation   annotations[num_annotations]
     */
    private int numAnnotations;
    private List<Annotation> annotations;

    public RuntimeVisibleAnnotations(ClassBuffer buffer, int attributeNameIndex) {
        super(buffer, attributeNameIndex);
        this.numAnnotations = buffer.u2();
        this.annotations = IntStream.range(0, this.numAnnotations).mapToObj(i -> new Annotation(buffer)).collect(Collectors.toList());
    }

    @Data
    private class Annotation {
        /**
         * u2   type_index
         * u2   num_element_value_pairs
         * {
         *     u2   element_name_index
         *     element_value    value
         * } element_value_pairs[num_element_value_pairs]
         */
        private int typeIndex;
        private int numElementValuePairs;
        private List<Object> elementValuePairs;

        public Annotation(ClassBuffer buffer) {
            this.typeIndex = buffer.u2();
            this.numElementValuePairs = buffer.u2();
        }
    }
}
