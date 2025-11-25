package assemble.language.operands;

import assemble.CommandUnit;
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
        firstRegister = operandsData >>> (CommandUnit.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        secondRegister = operandsData >>> (CommandUnit.SIZE - Register32.ADDRESS_SIZE);
        operandsData <<= Register32.ADDRESS_SIZE;
        thirdRegister = operandsData >>> (CommandUnit.SIZE - Register32.ADDRESS_SIZE);
    }
}
