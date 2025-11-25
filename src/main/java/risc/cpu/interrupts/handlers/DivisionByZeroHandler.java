package risc.cpu.interrupts.handlers;

import application.EmulationAbortException;
import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.DivisionByZeroException;

public class DivisionByZeroHandler implements InterruptHandler<DivisionByZeroException> {
    @Override
    public void handle(CPU cpu) throws EmulationAbortException {
        throw new EmulationAbortException("Division by zero. Emulation aborted");
    }
}
