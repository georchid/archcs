package assemble.numbers.integer.branching;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsN;

public class RET extends Instruction<OperandsN> {
    public RET() {
        super(80, "ret");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {
        cpu.programCounter.setValue(cpu.returnAddressRegister.getValue() & ~1);
    }
}
