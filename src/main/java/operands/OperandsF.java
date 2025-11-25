package operands;

import assemble.Instruction;
import memory.registers.StatusRegister;

public class OperandsF extends Operands {
    public int flagValue;

    public OperandsF(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        flagValue = operandsData >>> (Instruction.SIZE - StatusRegister.ADDRESS_SIZE);
    }
}
