package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRR;

public class SWP extends Instruction<OperandsRR> {
    public SWP() {
        super(86, "swp");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int tmp = cpu.intRegs.get(operands.firstRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(cpu.intRegs.get(operands.secondRegister).getValue());
        cpu.intRegs.get(operands.firstRegister).setValue(tmp);
    }
}
