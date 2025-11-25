package app;

public class EmulationAbortException extends Exception {
    public EmulationAbortException(String errorMessage) {
        super(errorMessage);
    }
}
