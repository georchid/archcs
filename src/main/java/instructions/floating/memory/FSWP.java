package instructions.floating.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRR;



public class FSWP extends Instruction<OperandsRR> {
    public FSWP() {
        super(87, "fswp");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int tmp = cpu.floatRegs.get(operands.firstRegister).getValue();
        cpu.floatRegs.get(operands.firstRegister).setValue(cpu.floatRegs.get(operands.secondRegister).getValue());
        cpu.floatRegs.get(operands.firstRegister).setValue(tmp);
    }
}