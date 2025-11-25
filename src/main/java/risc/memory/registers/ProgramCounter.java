package risc.memory.registers;

import risc.memory.cells.ByteCell;
import risc.memory.cells.WordCell;

public class ProgramCounter extends Register32 {
    public int postIncrementToNextInstruction() {
        int result = getValue();
        setValue(result + WordCell.SIZE / ByteCell.SIZE);
        return result;
    }

    public int add(int offset) {
        int result = getValue();
        setValue(result + offset);
        return getValue();
    }
}
