package cpu.interrupts.handlers;

import cpu.CPU;
import cpu.interrupts.exceptions.MemoryAddressOutOfBoundsException;

public class MemoryAddressOutOfBoundsHandler implements InterruptHandler<MemoryAddressOutOfBoundsException> {
    @Override
    public void handle(CPU cpu) {

    }
}
