package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsR;

public class OUT extends Instruction<OperandsR> {
    public OUT() {
        super(85, "out");
    }

    @Override
    public void execute(CPU cpu, OperandsR operands) throws InterruptException {
        cpu.port.sendDataToPin(cpu.intRegs.get(operands.register).getValue());
    }
}
