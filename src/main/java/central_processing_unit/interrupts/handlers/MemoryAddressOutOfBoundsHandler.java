package central_processing_unit.interrupts.handlers;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.MemoryAddressOutOfBoundsException;

public class MemoryAddressOutOfBoundsHandler implements InterruptHandler<MemoryAddressOutOfBoundsException> {
    @Override
    public void handle(CPU cpu) {

    }
}
