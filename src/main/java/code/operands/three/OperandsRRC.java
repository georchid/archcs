package code.operands.three;

import code.commands.Instruction;
import code.operands.Operands;
import risc.memory.registers.Register32;

public class OperandsRRC extends Operands {
    public int firstRegister;
    public int secondRegister;
    public int const12Bit;

    public OperandsRRC(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        firstRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        secondRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        const12Bit = operandsData >>> (Instruction.SIZE - 12);
    }
}
