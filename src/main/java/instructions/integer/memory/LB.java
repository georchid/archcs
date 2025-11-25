package instructions.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class LB extends Instruction<OperandsRRC> {

    public LB() {
        super(32, "lb");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.memory.getByte(upperPart + offset);

        cpu.intRegs.get(operands.firstRegister).setValue(value);
    }
}