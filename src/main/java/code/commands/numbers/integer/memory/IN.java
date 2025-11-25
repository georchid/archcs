package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsR;

public class IN extends Instruction<OperandsR> {
    public IN() {
        super(84, "in");
    }

    @Override
    public void execute(CPU cpu, OperandsR operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(cpu.port.receiveDataFromPin());
    }
}
