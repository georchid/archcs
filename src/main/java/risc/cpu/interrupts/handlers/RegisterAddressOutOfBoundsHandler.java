package risc.cpu.interrupts.handlers;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.RegisterAddressOutOfBoundsException;

public class RegisterAddressOutOfBoundsHandler implements InterruptHandler<RegisterAddressOutOfBoundsException> {
    @Override
    public void handle(CPU cpu) {

    }
}
