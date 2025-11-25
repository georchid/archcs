package assemble.special;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsN;

public class Nop extends CommandUnit<OperandsN> {
    public Nop() {
        super(83, "nop");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {

    }
}
