package instructions.integer.logical;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

// TODO: 24.12.2022
public class SRA extends Instruction<OperandsRRR> {
    public SRA() {
        super(26, "sra");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        int result = fstValue >> secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}