package assemble.numbers.floating.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRR;

public class FSW extends Instruction<OperandsRR> {
    public FSW() {
        super(51, "fswp");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int tmp = cpu.floatRegs.get(operands.firstRegister).getValue();
        cpu.floatRegs.get(operands.firstRegister).setValue(cpu.floatRegs.get(operands.secondRegister).getValue());
        cpu.floatRegs.get(operands.firstRegister).setValue(tmp);
    }
}
