package assemble.numbers.floating.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRR;

public class FMOV extends Instruction<OperandsRR> {
    public FMOV() {
        super(91, "fmov");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        cpu.floatRegs.get(operands.firstRegister).setValue(cpu.floatRegs.get(operands.secondRegister).getValue());
    }
}
