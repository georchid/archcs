package code.commands.numbers.integer.branching;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRC;

// TODO: 25.12.2022
public class JAL extends Instruction<OperandsRC> {

    public JAL() {
        super(44, "jal");
    }

    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(cpu.programCounter.getValue() + 4);
        cpu.programCounter.add(operands.const20Bit);
    }
}
