package risc.cpu.interrupts.handlers;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.UnknownInstructionException;

public class UnknownInstructionHandler implements InterruptHandler<UnknownInstructionException> {
    @Override
    public void handle(CPU cpu) {

    }
}
