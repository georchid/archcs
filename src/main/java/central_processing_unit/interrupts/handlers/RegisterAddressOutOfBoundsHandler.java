package central_processing_unit.interrupts.handlers;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.RegisterAddressOutOfBoundsException;

public class RegisterAddressOutOfBoundsHandler implements InterruptHandler<RegisterAddressOutOfBoundsException> {
    @Override
    public void handle(CPU cpu) {

    }
}
