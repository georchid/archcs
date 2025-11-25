package assemble.language.operands;

import assemble.CommandUnit;
import memory.registers.Register32;

public class OperandsRC extends Operands {
    public int register;
    public int const20Bit;

    public OperandsRC(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        register = operandsData >>> (CommandUnit.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        const20Bit = operandsData >>> (CommandUnit.SIZE - 20);
    }
}
