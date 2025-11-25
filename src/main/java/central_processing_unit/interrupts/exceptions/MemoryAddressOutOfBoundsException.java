package central_processing_unit.interrupts.exceptions;

public class MemoryAddressOutOfBoundsException extends InterruptException {
    public MemoryAddressOutOfBoundsException(String errorMessage) {
        super(3, false, errorMessage);
    }
    public MemoryAddressOutOfBoundsException(int i, boolean b,String  errorMessage) {
        super(3, false, errorMessage);
    }
}
