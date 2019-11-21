package jvmparse.parse.entity.instruction;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * Aload
 *
 * @author chenzb
 * @date 2019/11/20
 */
@Data
public class DConst extends Instruction {

    public DConst(ClassBuffer buffer, int opcode) {
        super(opcode);
    }

    public static class DConst0 extends Instruction {

        public DConst0(int opcode) {
            super(opcode);
        }
    }

    public static class DConst1 extends Instruction {

        public DConst1(int opcode) {
            super(opcode);
        }
    }

}
