package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRC;

public class LI extends Instruction<OperandsRC> {
    public LI() {
        super(70, "li");
    }

    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(operands.const20Bit);
    }
}
