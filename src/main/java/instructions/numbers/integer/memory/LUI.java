package instructions.numbers.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRC;

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
