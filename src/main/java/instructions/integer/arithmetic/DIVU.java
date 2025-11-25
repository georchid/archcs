package instructions.integer.arithmetic;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.DivisionByZeroException;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

public class DIVU extends Instruction<OperandsRRR> {
    public DIVU() {
        super(15, "divu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        if (secValue == 0){
            throw new DivisionByZeroException("Division by zero. Emulation aborted");
        }

        int result = Integer.divideUnsigned(fstValue, secValue);

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
