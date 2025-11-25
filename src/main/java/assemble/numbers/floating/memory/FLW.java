package assemble.numbers.floating.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsRRC;

public class FLW extends Instruction<OperandsRRC> {

    public FLW() {
        super(50, "flw");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.floatRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.memory.getWord(upperPart + offset);

        cpu.floatRegs.get(operands.firstRegister).setValue(value);
    }
}
