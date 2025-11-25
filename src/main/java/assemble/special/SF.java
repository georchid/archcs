package assemble.special;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsF;

public class SF extends Instruction<OperandsF> {
    public SF() {
        super(88, "sf");
    }

    @Override
    public void execute(CPU cpu, OperandsF operands) throws InterruptException {
        cpu.statusReg.setFlagStatus(Flag.fromValue(operands.flagValue), true);
    }
}
