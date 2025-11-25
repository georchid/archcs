package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRC;

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
