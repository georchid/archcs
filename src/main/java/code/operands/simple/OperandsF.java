package code.operands.simple;

import code.commands.Instruction;
import code.operands.Operands;
import risc.memory.registers.StatusRegister;

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
