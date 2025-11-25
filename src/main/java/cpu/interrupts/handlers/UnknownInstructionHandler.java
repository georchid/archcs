package cpu.interrupts.handlers;

import cpu.CPU;
import cpu.interrupts.exceptions.UnknownInstructionException;

public class UnknownInstructionHandler implements InterruptHandler<UnknownInstructionException> {
    @Override
    public void handle(CPU cpu) {

    }
}
