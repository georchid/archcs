package code.commands.numbers.integer.memory;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import risc.memory.cells.HalfWordCell;
import risc.memory.registers.Register32;
import code.operands.three.OperandsRRC;

// TODO: 25.12.2022
public class LHU extends Instruction<OperandsRRC> {

    public LHU() {
        super(34, "lhu");
    }

    @Override
    public void execute(CPU cpu, OperandsRRC operands) throws InterruptException {
        int upperPart = cpu.intRegs.get(operands.secondRegister).getValue();
        int offset = operands.const12Bit;

        int value = cpu.memory.getHalfWord(upperPart + offset);
        value = ((value << (Register32.SIZE - HalfWordCell.SIZE)) >>> (Register32.SIZE - HalfWordCell.SIZE));

        cpu.intRegs.get(operands.firstRegister).setValue(value);
    }
}
