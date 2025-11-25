package code.commands.numbers.integer.branching;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsN;

public class RET extends Instruction<OperandsN> {
    public RET() {
        super(80, "ret");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {
        cpu.programCounter.setValue(cpu.returnAddressRegister.getValue() & ~1);
    }
}
