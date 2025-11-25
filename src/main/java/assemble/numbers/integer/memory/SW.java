package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRRC;

// TODO: 24.12.2022
public class SW extends CommandUnit<OperandsRRC> {
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
