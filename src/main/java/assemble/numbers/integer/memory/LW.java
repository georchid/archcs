package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class LW extends Instruction<OperandsRRC> {

    public LW() {
        super(30, "lw");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.memory.getWord(upperPart + offset);

        cpu.intRegs.get(operands.firstRegister).setValue(value);
    }
}
