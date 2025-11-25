package assemble.numbers.integer.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRR;

public class MOV extends CommandUnit<OperandsRR> {
    public MOV() {
        super(71, "mov");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        cpu.intRegs.get(operands.firstRegister).setValue(cpu.intRegs.get(operands.secondRegister).getValue());
    }
}
