package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

// TODO: 25.12.2022
public class SH extends Instruction<OperandsRRC> {
    public SH() {
        super(37, "sh");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        short value = cpu.intRegs.get(operands.firstRegister).toHalfWord().getValue();

        cpu.memory.setHalfWord(upperPart + offset, value);
    }
}
