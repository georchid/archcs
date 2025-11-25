package code.commands.numbers.floating.arithmetic;

import risc.cpu.CPU;
import risc.cpu.Flag;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRR;

public class FSUB extends Instruction<OperandsRRR> {
    public FSUB() {
        super(47, "fsub");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        float fstValue = cpu.floatRegs.get(operands.secondRegister).getValueAsFloat();
        float secValue = cpu.floatRegs.get(operands.thirdRegister).getValueAsFloat();

        float result = fstValue - secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValueAsFloat(result);
    }
}
