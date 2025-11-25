package code.commands.numbers.floating.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;

public class FMOV extends Instruction<OperandsRR> {
    public FMOV() {
        super(91, "fmov");
    }

    @Override
    public void execute(CPU cpu, OperandsRR operands) throws InterruptException {
        cpu.floatRegs.get(operands.firstRegister).setValue(cpu.floatRegs.get(operands.secondRegister).getValue());
    }
}
