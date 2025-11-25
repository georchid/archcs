package assemble.language.operands;

import assemble.CommandUnit;

public class OperandsC extends Operands {
    public int const20Bit;

    public OperandsC(int operandsData) {
        super(operandsData);
    }

    @Override
    protected void disassemble(int operandsData) {
        const20Bit = operandsData >>> (CommandUnit.SIZE - 20);
    }
}
