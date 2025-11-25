package instructions.integer.logical;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRR;

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
