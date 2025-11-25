package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class MOV extends Instruction<OperandsRR> {
    public MOV() {
        super(71, "mov");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        cpu.intRegs.get(operands.firstRegister).setValue(cpu.intRegs.get(operands.secondRegister).getValue());
    }
}
