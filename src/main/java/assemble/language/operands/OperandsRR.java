package assemble.language.operands;

import assemble.CommandUnit;
import memory.registers.Register32;

public class OperandsRR extends Operands {
    public int firstRegister;
    public int secondRegister;

    public OperandsRR(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        firstRegister = operandsData >>> (CommandUnit.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        secondRegister = operandsData >>> (CommandUnit.SIZE - Register32.ADDRESS_SIZE);
    }
}
