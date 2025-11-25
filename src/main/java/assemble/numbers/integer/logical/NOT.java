package assemble.numbers.integer.logical;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRR;

public class NOT extends CommandUnit<OperandsRR> {
    public NOT() {
        super(72, "not");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int inv = ~cpu.intRegs.get(operands.secondRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(inv);
    }
}
