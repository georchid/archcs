package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsC;

public class CALL extends Instruction<OperandsC> {
    public CALL() {
        super(79, "call");
    }

    @Override
    public void execute(CPU cpu, OperandsC operands) throws InterruptException {
        int tmp = cpu.programCounter.getValue() + 4;
        cpu.programCounter.setValue(cpu.returnAddressRegister.getValue() + operands.const20Bit & ~1);
        cpu.returnAddressRegister.setValue(tmp);
    }
}
