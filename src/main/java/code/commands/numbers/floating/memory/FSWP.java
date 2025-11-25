package code.commands.numbers.floating.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRR;



public class FSWP extends Instruction<OperandsRR> {
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