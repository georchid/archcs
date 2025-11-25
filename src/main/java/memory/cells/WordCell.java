package memory.cells;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class WordCell implements Cell<Integer> {
    public static final int SIZE = 32;
    public static final int BYTES_NUMBER = 4;
    private final List<ByteCell> bytes;

    public WordCell() {
        this(0);
    }

    public WordCell(int word) {
        this.bytes = new ArrayList<>();
        var bytes = ByteBuffer.allocate(BYTES_NUMBER).putInt(word).array();
        for (var _byte : bytes) {
            this.bytes.add(new ByteCell(_byte));
        }
    }

    public WordCell(List<ByteCell> bytes) {
        this.bytes = bytes;
    }

    @Override
    public Integer getValue() {
        int value = 0;
        for (var _byte : bytes) {
            value = (value << 8) + (_byte.getValue() & 0xFF);
        }
        return value;
    }

    public Float getValueAsFloat() {
        return Float.intBitsToFloat(getValue());
    }

    @Override
    public void setValue(Integer value) {
        var bytes = ByteBuffer.allocate(4).putInt(value).array();
        for (int i = 0; i < BYTES_NUMBER; ++i) {
            this.bytes.get(i).setValue(bytes[i]);
        }
    }

    public void setValueAsFloat(Float value) {
        setValue(Float.floatToRawIntBits(value));
    }

    @Override
    public String toString() {
        return bytes.get(0).toString() + " " + bytes.get(1).toString()
                + " " + bytes.get(2).toString() + " " + bytes.get(3).toString();
    }

    @Override
    public void clear() {
        for (var _byte : bytes)
            _byte.clear();
    }

    @Override
    public ByteCell toByteCell() {
        return new ByteCell(bytes.get(3).getValue());
    }

    @Override
    public HalfWordCell toHalfWord() {
        List<ByteCell> bites = new ArrayList<>(){{
            add(new ByteCell(bytes.get(2).getValue()));
            add(new ByteCell(bytes.get(3).getValue()));
        }};
        return new HalfWordCell(bites);
    }

    @Override
    public WordCell toWordCell() {
        return new WordCell(getValue());
    }

}
