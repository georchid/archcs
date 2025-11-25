package assemble.numbers.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class LH extends Instruction<OperandsRRC> {

    public LH() {
        super(31, "lh");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.memory.getHalfWord(upperPart + offset);

        cpu.intRegs.get(operands.firstRegister).setValue(value);
    }
}
