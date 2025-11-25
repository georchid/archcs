package assemble.special;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsF;

public class CF extends Instruction<OperandsF> {
    public CF() {
        super(89, "cf");
    }

    @Override
    public void execute(CPU cpu, OperandsF operands) throws InterruptException {
        cpu.statusReg.setFlagStatus(Flag.fromValue(operands.flagValue), false);
    }
}
