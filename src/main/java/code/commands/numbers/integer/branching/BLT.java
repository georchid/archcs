package code.commands.numbers.integer.branching;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

// TODO: 25.12.2022
public class BLT extends Instruction<OperandsRRC> {
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
