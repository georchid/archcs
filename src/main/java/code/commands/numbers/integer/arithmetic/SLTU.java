package code.commands.numbers.integer.arithmetic;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRR;

public class SLTU extends Instruction<OperandsRRR> {
    public SLTU() {
        super(6, "sltu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();
        int result;

        int tmp = Integer.compareUnsigned(fstValue, secValue);
        result = tmp < 0 ? 1 : 0;

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}