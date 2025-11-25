package instructions.integer.arithmetic;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRC;

public class SLTI extends Instruction<OperandsRRC> {
    public SLTI() {
        super(5, "slti");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = operands.const12Bit;
        int result;

        result = fstValue < secValue ? 1 : 0;

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
