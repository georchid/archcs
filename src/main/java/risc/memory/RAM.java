package risc.memory;

import risc.memory.cells.ByteCell;
import risc.memory.cells.HalfWordCell;
import risc.memory.cells.WordCell;

import java.util.ArrayList;
import java.util.List;

public class RAM {
    private List<ByteCell> data;

    public RAM(int bytesCount) {
        if (bytesCount % WordCell.BYTES_NUMBER != 0)
            throw new IllegalArgumentException();
        data = new ArrayList<>(bytesCount);
        for (int count = 0; count < bytesCount; ++count)
            data.add(new ByteCell());
    }

    public int getSize() {
        return data.size();
    }

    public byte getByte(int index) {
        return data.get(index).getValue();
    }

    public void setByte(int index, byte _byte) {
        data.get(index).setValue(_byte);
    }

    public short getHalfWord(int index) {
        return new HalfWordCell(data.subList(index, index + HalfWordCell.BYTES_NUMBER)).getValue();
    }

    public void setHalfWord(int index, short halfWord) {
        new HalfWordCell(data.subList(index, index + HalfWordCell.BYTES_NUMBER)).setValue(halfWord);
    }

    public int getWord(int index) {
        return new WordCell(data.subList(index, index + WordCell.BYTES_NUMBER)).getValue();
    }

    public void setWord(int index, int word) {
        new WordCell(data.subList(index, index + WordCell.BYTES_NUMBER)).setValue(word);
    }

    public List<WordCell> asWordList() {
        List<WordCell> words = new ArrayList<>(data.size() / WordCell.BYTES_NUMBER);
        for (int i = 0; i < data.size(); i += WordCell.BYTES_NUMBER)
            words.add(new WordCell(data.subList(i, i + WordCell.BYTES_NUMBER)));
        return words;
    }

    public void clear() {
        for (var cell : data)
            cell.clear();
    }
}
