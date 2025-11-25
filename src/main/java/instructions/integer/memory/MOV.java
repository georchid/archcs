package instructions.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRR;

public class MOV extends Instruction<OperandsRR> {
    public MOV() {
        super(71, "mov");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        cpu.intRegs.get(operands.firstRegister).setValue(cpu.intRegs.get(operands.secondRegister).getValue());
    }
}
