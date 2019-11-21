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
public class ALoad extends Instruction {

    private int operand;

    public ALoad(ClassBuffer buffer, int opcode) {
        super(opcode);
        this.operand = buffer.u1();
    }

    public static class ALoad0 extends Instruction {

        public ALoad0(int opcode) {
            super(opcode);
        }
    }

    public static class ALoad1 extends Instruction {

        public ALoad1(int opcode) {
            super(opcode);
        }
    }

    public static class ALoad2 extends Instruction {

        public ALoad2(int opcode) {
            super(opcode);
        }
    }

    public static class ALoad3 extends Instruction {

        public ALoad3(int opcode) {
            super(opcode);
        }
    }
}
