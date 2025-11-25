package cpu.interrupts.exceptions;

public abstract class InterruptException extends Exception {
    private final int vector;
    private final boolean isMaskable;

    public InterruptException(int vector, boolean isMaskable, String errorMessage) {
        super(errorMessage);
        this.vector = vector;
        this.isMaskable = isMaskable;
    }

    public int getVector() {
        return vector;
    }

    public boolean isMaskable() {
        return isMaskable;
    }
}
