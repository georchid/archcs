package code.commands;

import risc.cpu.CPU;
import risc.cpu.interrupts.exceptions.InterruptException;
import code.operands.Operands;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class Instruction<T extends Operands> {
    private static Map<Integer, Instruction> OPCODES = null;
    private static Map<String, Instruction> MNEMONICS = null;
    private static List<Instruction> VALUES = null;
    public static int OPCODE_SIZE = 7;
    public static int SIZE = 32;
    private final int opcode;
    private final String mnemonic;

    public Instruction(int opcode, String mnemonic) {
        this.opcode = opcode;
        this.mnemonic = mnemonic.toLowerCase();
    }

    public int getOpcode() {
        return opcode;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public abstract void execute(CPU cpu, T operands) throws InterruptException;

    public static List<Instruction> values() {
        if (VALUES == null) {
            try {
                var reflections = new Reflections("commands");
                var subclasses = reflections.getSubTypesOf(Instruction.class);
                List<Instruction> values = new ArrayList<>();
                for (var subclass : subclasses) {
                    values.add(subclass.getConstructor().newInstance());
                }
                VALUES = Collections.unmodifiableList(values);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return VALUES;
    }

    // TODO: program end exception, unknown instruction exception
    public static Instruction fromOpcode(int opcode) {
        if (OPCODES == null) {
            try {
                var reflections = new Reflections("commands");
                var subclasses = reflections.getSubTypesOf(Instruction.class);
                Map<Integer, Instruction> opcodes = new HashMap<>();
                for (var subclass : subclasses) {
                    Instruction _subclass = subclass.getConstructor().newInstance();
                    opcodes.put(_subclass.getOpcode(), _subclass);
                }
                OPCODES = Collections.unmodifiableMap(opcodes);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return OPCODES.get(opcode);
    }

    // unknown instruction exception
    public static Instruction fromMnemonic(String mnemonic) {
        if (MNEMONICS == null) {
            try {
                var reflections = new Reflections("commands");
                var subclasses = reflections.getSubTypesOf(Instruction.class);
                Map<String, Instruction> mnemonics = new HashMap<>();
                for (var subclass : subclasses) {
                    Instruction _subclass = subclass.getConstructor().newInstance();
                    mnemonics.put(_subclass.getMnemonic(), _subclass);
                }
                MNEMONICS = Collections.unmodifiableMap(mnemonics);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return MNEMONICS.get(mnemonic.toLowerCase());
    }
}

/*public enum Instruction {
    NOP(1, Format.N, new Nop()),
    ADD(2, Format.RRR, new Nop());

    public enum Format {
        N, F, C, RR, RC, RRR, RRC
    }

    private final int opcode;
    private final Format format;
    private final InstructionExecutor executor;
    private static final HashMap<Integer, Instruction> OPCODES;
    private static final HashMap<String, Instruction> MNEMONICS;
    public static final int SIZE = 7;

    static {
        OPCODES = new HashMap<>();
        MNEMONICS = new HashMap<>();
        for (var instruction : Instruction.values()) {
            OPCODES.put(instruction.opcode, instruction);
            MNEMONICS.put(instruction.name(), instruction);
        }
    }

    Instruction(int opcode, Format format, InstructionExecutor executor) {
        this.opcode = opcode;
        this.format = format;
        this.executor = executor;
    }

    public int getOpcode() {
        return opcode;
    }

    public String getMnemonic() {
        return name();
    }

    public Format getFormat() {
        return format;
    }

    public void execute(CentralProcessingUnit risc.cpu, List<Integer> code.operands) {
        executor.execute(risc.cpu, code.operands);
    }

    static public Instruction fromOpcode(int opcode) {
        return OPCODES.get(opcode);
    }

    static public Instruction fromMnemonic(String name) {
        return MNEMONICS.get(name);
    }
}*/