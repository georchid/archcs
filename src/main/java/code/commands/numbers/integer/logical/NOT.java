package code.commands.numbers.integer.logical;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class NOT extends Instruction<OperandsRR> {
    public NOT() {
        super(72, "not");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int inv = ~cpu.intRegs.get(operands.secondRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(inv);
    }
}
