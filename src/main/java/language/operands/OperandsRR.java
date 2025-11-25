package language.operands;

import assemble.Instruction;
import memory.registers.Register32;

public class OperandsRR extends Operands {
    public int firstRegister;
    public int secondRegister;

    public OperandsRR(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        firstRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        secondRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
    }
}
