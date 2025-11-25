package instructions.integer.branching;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsC;

public class JMP extends Instruction<OperandsC> {
    public JMP() {
        super(78, "jmp");
    }

    @Override
    public void execute(CPU cpu, OperandsC operands) throws InterruptException {
        cpu.programCounter.add(operands.const20Bit);
    }
}
