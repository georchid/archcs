package assemble.numbers.integer.arithmetic;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRRR;

public class SLT extends Instruction<OperandsRRR> {
    public SLT() {
        super(4, "slt");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();
        int result;

        result = fstValue < secValue ? 1 : 0;

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}