package code.commands.special;

import risc.cpu.CPU;
import risc.cpu.Flag;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsF;

public class CF extends Instruction<OperandsF> {
    public CF() {
        super(89, "cf");
    }

    @Override
    public void execute(CPU cpu, OperandsF operands) throws InterruptException {
        cpu.statusReg.setFlagStatus(Flag.fromValue(operands.flagValue), false);
    }
}
