package assemble.numbers.integer.arithmetic;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsRR;

public class NEG extends Instruction<OperandsRR> {
    public NEG() {
        super(73, "neg");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        int neg = -cpu.intRegs.get(operands.secondRegister).getValue();
        cpu.intRegs.get(operands.firstRegister).setValue(neg);
    }
}
