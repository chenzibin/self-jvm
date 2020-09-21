package self.jvm.parse.parse.entity.instruction;

import self.jvm.parse.parse.ClassBuffer;
import lombok.Data;

/**
 * Aload
 *
 * @author chenzb
 * @date 2019/11/20
 */
@Data
public class PutField extends Instruction {

    private int operand;

    public PutField(ClassBuffer buffer, int opcode) {
        super(opcode);
        this.operand = buffer.u2();
    }
}
