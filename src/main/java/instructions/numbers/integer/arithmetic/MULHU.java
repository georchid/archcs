package instructions.numbers.integer.arithmetic;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

public class MULHU extends Instruction<OperandsRRR> {
    public MULHU() {
        super(13, "mulhu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        int result = (int)((((((long)fstValue) << 32) >>> 32) * ((((long)secValue) << 32) >>> 32)) >> 32);

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
