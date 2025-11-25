package risc.cpu.interrupts.handlers;

import application.EmulationAbortException;
import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;

public interface InterruptHandler<T extends InterruptException> {
    void handle(CPU cpu) throws EmulationAbortException;
}
