package instructions.numbers.integer.arithmetic;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

public class MUL extends Instruction<OperandsRRR> {
    public MUL() {
        super(10, "mul");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        int result = fstValue * secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.statusReg.setFlagStatus(Flag.OVERFLOW, (fstValue != 0 && result / fstValue != secValue));

        cpu.statusReg.setFlagStatus(Flag.CARRY, (fstValue != 0 && result / fstValue != secValue));

        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
