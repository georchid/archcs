package instructions.integer.branching;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class BLTU extends Instruction<OperandsRRC> {
    public BLTU() {
        super(43, "bltu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.firstRegister).getValue();
        int secValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int tmp = Integer.compareUnsigned(fstValue, secValue);
        if (tmp == -1) {
            cpu.programCounter.add(offset);
        }
    }
}
