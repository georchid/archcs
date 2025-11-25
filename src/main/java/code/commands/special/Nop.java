package code.commands.special;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsN;

public class Nop extends Instruction<OperandsN> {
    public Nop() {
        super(83, "nop");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {

    }
}
