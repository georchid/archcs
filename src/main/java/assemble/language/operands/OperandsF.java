package assemble.language.operands;

import assemble.CommandUnit;
import memory.registers.StatusRegister;

public class OperandsF extends Operands {
    public int flagValue;

    public OperandsF(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        flagValue = operandsData >>> (CommandUnit.SIZE - StatusRegister.ADDRESS_SIZE);
    }
}
