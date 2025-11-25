package risc.memory.registers;

import risc.cpu.Flag;

public class StatusRegister extends Register8 {
    public boolean getFlagStatus(Flag flag) {
        return (getValue() & flag.getValue()) != 0;
    }

    public void setFlagStatus(Flag flag, boolean status) {
        setValue((byte)((status) ? (getValue() | flag.getValue()) : (getValue() & ~flag.getValue())));
    }

    public void invertFlagStatus(Flag flag) {
        setFlagStatus(flag, !getFlagStatus(flag));
    }

    @Override
    public String toString() {
        return super.toString().replaceAll("(.)", "$1    ").trim();
    }
}
