package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class SWP extends Instruction<OperandsRR> {
    public SWP() {
        super(86, "swp");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int tmp = cpu.intRegs.get(operands.firstRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(cpu.intRegs.get(operands.secondRegister).getValue());
        cpu.intRegs.get(operands.firstRegister).setValue(tmp);
    }
}
