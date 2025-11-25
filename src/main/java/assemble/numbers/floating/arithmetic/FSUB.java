package assemble.numbers.floating.arithmetic;

import central_processing_unit.CPU;
import central_processing_unit.Flag;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRRR;

public class FSUB extends CommandUnit<OperandsRRR> {
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
