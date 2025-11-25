package assemble.numbers.integer.arithmetic;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRR;

public class NEG extends CommandUnit<OperandsRR> {
    public NEG() {
        super(73, "neg");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int neg = -cpu.intRegs.get(operands.secondRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(neg);
    }
}
