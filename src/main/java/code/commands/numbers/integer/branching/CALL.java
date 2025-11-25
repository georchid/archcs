package code.commands.numbers.integer.branching;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsC;

public class CALL extends Instruction<OperandsC> {
    public CALL() {
        super(79, "call");
    }

    @Override
    public void execute(CPU cpu, OperandsC operands) throws InterruptException {
        int tmp = cpu.programCounter.getValue() + 4;
        cpu.programCounter.setValue(cpu.returnAddressRegister.getValue() + operands.const20Bit & ~1);
        cpu.returnAddressRegister.setValue(tmp);
    }
}
