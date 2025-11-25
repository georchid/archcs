package central_processing_unit.interrupts.handlers;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.UnknownInstructionException;

public class UnknownInstructionHandler implements InterruptHandler<UnknownInstructionException> {
    @Override
    public void handle(CPU cpu) {

    }
}
