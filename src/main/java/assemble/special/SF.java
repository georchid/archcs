package assemble.special;

import central_processing_unit.CPU;
import central_processing_unit.Flag;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.CommandUnit;
import assemble.language.operands.OperandsF;

public class SF extends CommandUnit<OperandsF> {
    public SF() {
        super(88, "sf");
    }

    @Override
    public void execute(CPU cpu, OperandsF operands) throws InterruptException {
        cpu.statusReg.setFlagStatus(Flag.fromValue(operands.flagValue), true);
    }
}
