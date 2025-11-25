package central_processing_unit.ports;

import memory.cells.WordCell;

public class Port {
    private final WordCell inputPin;
    private final WordCell outputPin;

    public Port() {
        this.inputPin = new WordCell();
        this.outputPin = new WordCell();
    }

    public void sendDataToPin(int value) {
        outputPin.setValue(value);
    }

    public int receiveDataFromPin() {
        return inputPin.getValue();
    }
}
