package operands;

import cpu.Flag;
import instructions.Instruction;
import memory.registers.Register32;
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
