package assemble.special;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsN;

public class Nop extends Instruction<OperandsN> {
    public Nop() {
        super(83, "nop");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {

    }
}
