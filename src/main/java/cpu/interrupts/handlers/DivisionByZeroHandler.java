package cpu.interrupts.handlers;

import app.EmulationAbortException;
import cpu.CPU;
import cpu.interrupts.exceptions.DivisionByZeroException;

public class DivisionByZeroHandler implements InterruptHandler<DivisionByZeroException> {
    @Override
    public void handle(CPU cpu) throws EmulationAbortException {
        throw new EmulationAbortException("Division by zero. Emulation aborted");
    }
}
