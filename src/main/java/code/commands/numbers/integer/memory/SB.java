package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

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
