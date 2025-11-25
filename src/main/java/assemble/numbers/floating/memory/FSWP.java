package assemble.numbers.floating.memory;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsRR;



public class FSWP extends CommandUnit<OperandsRR> {
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