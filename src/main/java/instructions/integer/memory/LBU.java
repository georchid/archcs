package instructions.integer.memory;

import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;
import instructions.Instruction;
import memory.cells.ByteCell;
import memory.registers.Register32;
import operands.OperandsRRC;

// TODO: 25.12.2022
public class LBU extends Instruction<OperandsRRC> {

    public LBU() {
        super(35, "lbu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.memory.getByte(upperPart + offset);
        value = ((value << (Register32.SIZE - ByteCell.SIZE)) >>> (Register32.SIZE - ByteCell.SIZE));

        cpu.intRegs.get(operands.firstRegister).setValue(value);
    }
}
