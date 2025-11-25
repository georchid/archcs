package operands;

import instructions.Instruction;
import memory.registers.Register32;

public class OperandsRRR extends Operands {
    public int firstRegister; // чаще всего регистр назначения, но не всегда
    public int secondRegister;
    public int thirdRegister;

    public OperandsRRR(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        firstRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        secondRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        thirdRegister = operandsData >>> (Instruction.SIZE - Register32.ADDRESS_SIZE);
    }
}
