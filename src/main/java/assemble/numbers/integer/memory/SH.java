package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRRC;

// TODO: 25.12.2022
public class SH extends CommandUnit<OperandsRRC> {
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
