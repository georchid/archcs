package instructions.numbers.integer.branching;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class BNE extends Instruction<OperandsRRC> {

    public BNE() {
        super(40, "bne");
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
