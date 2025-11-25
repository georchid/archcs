package assemble.numbers.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsR;

public class IN extends Instruction<OperandsR> {
    public IN() {
        super(84, "in");
    }

    @Override
    public void execute(CPU cpu, OperandsR operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(cpu.port.receiveDataFromPin());
    }
}
