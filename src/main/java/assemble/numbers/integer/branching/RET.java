package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsN;

public class RET extends Instruction<OperandsN> {
    public RET() {
        super(80, "ret");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {
        cpu.programCounter.setValue(cpu.returnAddressRegister.getValue() & ~1);
    }
}
