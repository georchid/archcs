package assemble.special;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsN;

public class Nop extends Instruction<OperandsN> {
    public Nop() {
        super(83, "nop");
    }

    @Override
    public void execute(CPU cpu, OperandsN operands) throws InterruptException {

    }
}
