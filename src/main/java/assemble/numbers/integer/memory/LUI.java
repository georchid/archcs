package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsRC;

public class LUI extends Instruction<OperandsRC> {
    public LUI() {
        super(8, "lui");
    }

    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        int fstValue = operands.const20Bit;

        int result = fstValue << 12;

        cpu.intRegs.get(operands.register).setValue(result);
    }
}
