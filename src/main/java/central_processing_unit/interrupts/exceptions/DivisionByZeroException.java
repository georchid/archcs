package central_processing_unit.interrupts.exceptions;

public class DivisionByZeroException extends InterruptException {
    public DivisionByZeroException(String errorMessage) {
        super(0, false, errorMessage);
    }
    public DivisionByZeroException(int i, boolean b,String errorMessage) {
        super(0, false, errorMessage);
    }
}
