package cpu.interrupts.exceptions;

public class UnknownInstructionException extends InterruptException {
    public UnknownInstructionException(String errorMessage) {
        super(1, false, errorMessage);
    }
    public UnknownInstructionException(int i, boolean b, String errorMessage) {
        super(1, false, errorMessage);
    }
}
