package instructions.numbers.integer.arithmetic;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRC;

public class SLTIU extends Instruction<OperandsRRC> {
    public SLTIU() {
        super(7, "sltiu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = operands.const12Bit;
        int result;

        int tmp = Integer.compareUnsigned(fstValue, secValue);
        result = tmp < 0 ? 1 : 0;

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
