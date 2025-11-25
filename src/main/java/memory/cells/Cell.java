package memory.cells;

import java.util.List;

public interface Cell<T extends Number> {
    T getValue();
    void setValue(T value);
    void clear();
    ByteCell toByteCell();
    HalfWordCell toHalfWord();
    WordCell toWordCell();
}
