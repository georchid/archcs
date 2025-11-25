package code.commands.numbers.integer.arithmetic;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.two.OperandsRC;

public class AUIPC extends Instruction<OperandsRC> {
    public AUIPC() {
        super(9, "auipc");
    }

    // TODO: 24.12.2022
    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        int fstValue = operands.const20Bit;

        int result = cpu.programCounter.getValue() + (fstValue << 12);

        cpu.intRegs.get(operands.register).setValue(result);
    }
}