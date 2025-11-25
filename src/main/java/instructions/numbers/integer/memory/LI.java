package instructions.numbers.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRC;

public class LI extends Instruction<OperandsRC> {
    public LI() {
        super(70, "li");
    }

    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(operands.const20Bit);
    }
}
