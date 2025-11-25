package assemble.numbers.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class SB extends Instruction<OperandsRRC> {
    public SB() {
        super(38, "sb");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        byte value = cpu.intRegs.get(operands.firstRegister).toByteCell().getValue();

        cpu.memory.setByte(upperPart + offset, value);
    }
}
