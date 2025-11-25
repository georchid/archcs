package code.commands.numbers.integer.branching;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsC;

public class JMP extends Instruction<OperandsC> {
    public JMP() {
        super(78, "jmp");
    }

    @Override
    public void execute(CPU cpu, OperandsC operands) throws InterruptException {
        cpu.programCounter.add(operands.const20Bit);
    }
}
