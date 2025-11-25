package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRC;

public class LI extends CommandUnit<OperandsRC> {
    public LI() {
        super(70, "li");
    }

    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(operands.const20Bit);
    }
}
