package instructions.floating.arithmetic;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.DivisionByZeroException;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

public class FDIV extends Instruction<OperandsRRR> {
    public FDIV() {
        super(48, "fdiv");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        float fstValue = cpu.floatRegs.get(operands.secondRegister).getValueAsFloat();
        float secValue = cpu.floatRegs.get(operands.thirdRegister).getValueAsFloat();

        float result = fstValue / secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);


        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValueAsFloat(result);
    }
}
