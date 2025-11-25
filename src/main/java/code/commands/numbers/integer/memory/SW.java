package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

// TODO: 24.12.2022
public class SW extends Instruction<OperandsRRC> {
    public SW() {
        super(36, "sh");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.intRegs.get(operands.firstRegister).getValue();

        cpu.memory.setWord(upperPart + offset, value);
    }
}
