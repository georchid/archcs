package code.commands.special;

import risc.cpu.CPU;
import risc.cpu.Flag;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsF;

public class SF extends Instruction<OperandsF> {
    public SF() {
        super(88, "sf");
    }

    @Override
    public void execute(CPU cpu, OperandsF operands) throws InterruptException {
        cpu.statusReg.setFlagStatus(Flag.fromValue(operands.flagValue), true);
    }
}
