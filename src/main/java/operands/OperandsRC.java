package operands;

import assemble.Instruction;
import memory.registers.Register32;

public class OperandsRC extends Operands {
    public int register;
    public int const20Bit;

    public OperandsRC(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        register = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        const20Bit = operandsData >>> (Instruction.SIZE - 20);
    }
}
