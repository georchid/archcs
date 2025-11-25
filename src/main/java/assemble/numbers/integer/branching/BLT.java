package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRRC;

// TODO: 25.12.2022
public class BLT extends CommandUnit<OperandsRRC> {
    public BLT() {
        super(42, "blt");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.firstRegister).getValue();
        int secValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        if (fstValue < secValue) {
            cpu.programCounter.add(offset);
        }
    }
}
