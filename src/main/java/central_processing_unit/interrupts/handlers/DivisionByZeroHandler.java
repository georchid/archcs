package central_processing_unit.interrupts.handlers;

import application.EmulationAbortException;
import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.DivisionByZeroException;

public class DivisionByZeroHandler implements InterruptHandler<DivisionByZeroException> {
    @Override
    public void handle(CPU cpu) throws EmulationAbortException {
        throw new EmulationAbortException("Division by zero. Emulation aborted");
    }
}
