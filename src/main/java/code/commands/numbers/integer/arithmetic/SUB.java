package code.commands.numbers.integer.arithmetic;

import risc.cpu.CPU;
import risc.cpu.Flag;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.commands.Instruction;
import code.operands.three.OperandsRRR;

public class SUB extends Instruction<OperandsRRR> {
    public SUB() {
        super(2, "sub");
    }

    @Override
    public void execute(CPU cpu, OperandsRRR operands) throws InterruptException {
        int fstValue = cpu.intRegs.get(operands.secondRegister).getValue();
        int secValue = cpu.intRegs.get(operands.thirdRegister).getValue();

        int result = fstValue - secValue;

        cpu.statusReg.setFlagStatus(Flag.ZERO, result == 0);

        cpu.statusReg.setFlagStatus(Flag.OVERFLOW, ((~fstValue & secValue & ~result) | (fstValue & ~secValue & result)) < 0);

        cpu.statusReg.setFlagStatus(Flag.CARRY, (fstValue ^ Integer.MIN_VALUE) < (secValue ^ Integer.MIN_VALUE));

        cpu.statusReg.setFlagStatus(Flag.SIGN, result < 0);

        cpu.intRegs.get(operands.firstRegister).setValue(result);
    }
}
