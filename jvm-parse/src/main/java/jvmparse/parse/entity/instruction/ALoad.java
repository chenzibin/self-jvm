package jvmparse.parse.entity.instruction;

import jvmparse.parse.ClassBuffer;

/**
 * Aload
 *
 * @author chenzb
 * @date 2019/11/20
 */
public class ALoad extends Instruction {

    private int operand;

    public ALoad(ClassBuffer buffer, int opcode) {
        super(opcode);
        this.operand = buffer.u1();
    }
}
