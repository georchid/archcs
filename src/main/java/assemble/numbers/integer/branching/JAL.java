package assemble.numbers.integer.branching;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.Instruction;
import operands.OperandsRC;

// TODO: 25.12.2022
public class JAL extends Instruction<OperandsRC> {

    public JAL() {
        super(44, "jal");
    }

    @Override
    public void execute(CPU cpu, OperandsRC operands) throws InterruptException {
        cpu.intRegs.get(operands.register).setValue(cpu.programCounter.getValue() + 4);
        cpu.programCounter.add(operands.const20Bit);
    }
}
