package central_processing_unit.interrupts.handlers;

import application.EmulationAbortException;
import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;

public interface InterruptHandler<T extends InterruptException> {
    void handle(CPU cpu) throws EmulationAbortException;
}
