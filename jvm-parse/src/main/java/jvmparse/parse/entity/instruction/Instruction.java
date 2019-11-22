package jvmparse.parse.entity.instruction;

import lombok.Data;

/**
 * Instruction
 *
 * @author chenzb
 * @date 2019/11/20
 */
@Data
public class Instruction {

    private int opcode;

    public Instruction(int opcode) {
        this.opcode = opcode;
    }
}
