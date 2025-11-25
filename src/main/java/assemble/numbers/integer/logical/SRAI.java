package assemble.numbers.integer.logical;

import central_processing_unit.CPU;
import central_processing_unit.Flag;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRRC;

public class SRAI extends CommandUnit<OperandsRRC> {
    public SRAI() {
        super(29, "srai");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = operands.const12Bit;

        int result = fstValue >> secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
