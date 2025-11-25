package assemble.numbers.integer.arithmetic;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import language.operands.OperandsRRR;

public class SLTU extends Instruction<OperandsRRR> {
    public SLTU() {
        super(6, "sltu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();
        int result;

        int tmp = Integer.compareUnsigned(fstValue, secValue);
        result = tmp < 0 ? 1 : 0;

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}