package memory.cells;

import java.util.ArrayList;
import java.util.List;

public class ByteCell implements Cell<Byte> {
    public static final int SIZE = 8;
    private Byte value;

    public ByteCell() {
        this((byte) 0);
    }

    public ByteCell(Byte value) {
        this.value = value;
    }

    @Override
    public Byte getValue() {
        return value;
    }

    @Override
    public void setValue(Byte value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%8s", Integer.toBinaryString(value & 0xFF)).replace(' ', '0');
    }

    @Override
    public void clear() {
        value = 0;
    }

    @Override
    public ByteCell toByteCell() {
        return new ByteCell(value);
    }

    @Override
    public HalfWordCell toHalfWord() {
        List<ByteCell> bites = new ArrayList<>(){{
            add(new ByteCell());
            add(new ByteCell(value));
        }};

        return new HalfWordCell(bites);
    }

    @Override
    public WordCell toWordCell() {
        List<ByteCell> bites = new ArrayList<>(){{
            add(new ByteCell());
            add(new ByteCell());
            add(new ByteCell());
            add(new ByteCell(value));
        }};

        return new WordCell(bites);
    }


}
