package code.commands.numbers.floating.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class FCVTSW extends Instruction<OperandsRR> {
    public FCVTSW() {
        super(53, "fcvtsw");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int cvt = cpu.intRegs.get(operands.firstRegister).getValue();
        cpu.floatRegs.get(operands.secondRegister).setValueAsFloat((float)cvt);
    }
}
