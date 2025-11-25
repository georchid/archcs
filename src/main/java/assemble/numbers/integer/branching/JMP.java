package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsC;

public class JMP extends Instruction<OperandsC> {
    public JMP() {
        super(78, "jmp");
    }

    @Override
    public void execute(CPU cpu, OperandsC operands) throws InterruptException {
        cpu.programCounter.add(operands.const20Bit);
    }
}
