package central_processing_unit.interrupts.exceptions;

public class UnknownInstructionException extends InterruptException {
    public UnknownInstructionException(String errorMessage) {
        super(1, false, errorMessage);
    }
    public UnknownInstructionException(int i, boolean b, String errorMessage) {
        super(1, false, errorMessage);
    }
}
