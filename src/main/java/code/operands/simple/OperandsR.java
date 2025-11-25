package code.operands.simple;

import code.commands.Instruction;
import code.operands.Operands;
import risc.memory.registers.Register32;

public class OperandsR extends Operands {
    public int register;

    public OperandsR(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        register = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
    }
}
