package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsN;

public class RET extends CommandUnit<OperandsN> {
    public RET() {
        super(80, "ret");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {
        cpu.programCounter.setValue(cpu.returnAddressRegister.getValue() & ~1);
    }
}
