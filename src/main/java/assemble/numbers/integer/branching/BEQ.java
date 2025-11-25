package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class BEQ extends Instruction<OperandsRRC> {

    public BEQ() {
        super(39, "beq");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.firstRegister).getValue();
        int secValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        if (fstValue != secValue) {
            cpu.programCounter.add(offset);
        }
    }
}
