package assemble.numbers.integer.arithmetic;

import central_processing_unit.CPU;
import central_processing_unit.Flag;
import central_processing_unit.interrupts.exceptions.DivisionByZeroException;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRRR;

public class REM extends CommandUnit<OperandsRRR> {
    public REM() {
        super(16, "rem");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        if (secValue == 0){
            throw new DivisionByZeroException("Division by zero. Emulation aborted");
        }

        int result = fstValue % secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.statusReg.setFlagStatus(Flag.OVERFLOW, fstValue == Integer.MIN_VALUE && secValue == -1);

        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
