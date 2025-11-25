package code.commands.numbers.integer.arithmetic;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class NEG extends Instruction<OperandsRR> {
    public NEG() {
        super(73, "neg");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int neg = -cpu.intRegs.get(operands.secondRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(neg);
    }
}
