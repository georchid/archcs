package code.commands.numbers.integer.arithmetic;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

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
