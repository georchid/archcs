package instructions.numbers.integer.logical;

import cpu.CPU;
import cpu.Flag;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRR;

// TODO: 24.12.2022
public class SRL extends Instruction<OperandsRRR> {
    public SRL() {
        super(25, "srl");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        int result = fstValue >>> secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}