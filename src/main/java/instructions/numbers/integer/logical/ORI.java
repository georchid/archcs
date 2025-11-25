package instructions.numbers.integer.logical;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRC;

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
