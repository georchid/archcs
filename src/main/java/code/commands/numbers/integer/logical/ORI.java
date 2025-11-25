package code.commands.numbers.integer.logical;

import risc.cpu.CPU;
import risc.cpu.Flag;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

public class ORI extends Instruction<OperandsRRC> {
    public ORI() {
        super(22, "ori");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = operands.const12Bit;

        int result = fstValue | secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
