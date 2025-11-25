package risc.cpu.interrupts.handlers;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.MemoryAddressOutOfBoundsException;

public class MemoryAddressOutOfBoundsHandler implements InterruptHandler<MemoryAddressOutOfBoundsException> {
    @Override
    public void handle(CPU cpu) {

    }
}
