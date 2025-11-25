package instructions.floating.arithmetic;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

public class FMUL extends Instruction<OperandsRRR> {
    public FMUL() {
        super(49, "fmul");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        float fstValue = cpu.floatRegs.get(operands.secondRegister).getValueAsFloat();
        float secValue = cpu.floatRegs.get(operands.thirdRegister).getValueAsFloat();

        float result = fstValue * secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);


        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValueAsFloat(result);
    }
}
