package code.commands.numbers.integer.branching;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRC;

// TODO: 25.12.2022
public class JALR extends Instruction<OperandsRRC> {

    public JALR() {
        super(45, "jalr");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int tmp = cpu.programCounter.getValue() + 4;
        cpu.programCounter.setValue((cpu.intRegs.get(operands.secondRegister).getValue() + operands.const12Bit)&~1);
        cpu.intRegs.get(operands.firstRegister).setValue(tmp);
    }
}
