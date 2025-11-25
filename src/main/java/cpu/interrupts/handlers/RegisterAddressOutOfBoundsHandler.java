package cpu.interrupts.handlers;

import cpu.CPU;
import cpu.interrupts.exceptions.RegisterAddressOutOfBoundsException;

public class RegisterAddressOutOfBoundsHandler implements InterruptHandler<RegisterAddressOutOfBoundsException> {
    @Override
    public void handle(CPU cpu) {

    }
}
