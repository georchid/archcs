package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.simple.OperandsR;

public class OUT extends Instruction<OperandsR> {
    public OUT() {
        super(85, "out");
    }

    @Override
    public void execute(CPU cpu, OperandsR operands) throws InterruptException {
        cpu.port.sendDataToPin(cpu.intRegs.get(operands.register).getValue());
    }
}
