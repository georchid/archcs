package assemble.numbers.floating.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRR;

public class FCVTWS extends Instruction<OperandsRR> {
    public FCVTWS() {
        super(54, "fcvtws");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        float cvt = cpu.floatRegs.get(operands.firstRegister).getValueAsFloat();
        cpu.intRegs.get(operands.secondRegister).setValue((int)cvt);
    }
}
