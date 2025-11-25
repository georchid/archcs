package cpu.interrupts.handlers;

import app.EmulationAbortException;
import cpu.CPU;
import cpu.interrupts.exceptions.InterruptException;

public interface InterruptHandler<T extends InterruptException> {
    void handle(CPU cpu) throws EmulationAbortException;
}
