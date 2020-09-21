package self.jvm.parse.parse.entity.instruction;

import lombok.Data;

/**
 * Aload
 *
 * @author chenzb
 * @date 2019/11/20
 */
@Data
public class Return extends Instruction {

    public Return(int opcode) {
        super(opcode);
    }
}
