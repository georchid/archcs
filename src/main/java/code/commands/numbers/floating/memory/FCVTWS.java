package code.commands.numbers.floating.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class FCVTWS extends Instruction<OperandsRR> {
    public FCVTWS() {
        super(54, "fcvtws");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        float cvt = cpu.floatRegs.get(operands.firstRegister).getValueAsFloat();
        cpu.intRegs.get(operands.secondRegister).setValue((int)cvt);
    }
}
