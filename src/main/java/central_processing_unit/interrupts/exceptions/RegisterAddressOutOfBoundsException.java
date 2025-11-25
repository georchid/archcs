package central_processing_unit.interrupts.exceptions;

public class RegisterAddressOutOfBoundsException extends InterruptException {
    public RegisterAddressOutOfBoundsException(String errorMessage) {
        super(4, false, errorMessage);
    }
    public RegisterAddressOutOfBoundsException(int i, boolean bool, String errorMessage) {
        super(4, false, errorMessage);
    }
}
