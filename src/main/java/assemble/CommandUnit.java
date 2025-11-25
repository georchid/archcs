package assemble;

import central_processing_unit.CPU;
import central_processing_unit.interrupts.exceptions.InterruptException;
import assemble.language.operands.Operands;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public abstract class CommandUnit<T extends Operands> {
    private static Map<Integer, CommandUnit> OPCODES = null;
    private static Map<String, CommandUnit> MNEMONICS = null;
    private static List<CommandUnit> VALUES = null;
    public static int OPCODE_SIZE = 7;
    public static int SIZE = 32;
    private final int opcode;
    private final String mnemonic;

    public CommandUnit(int opcode, String mnemonic) {
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

    public static List<CommandUnit> values() {
        if (VALUES == null) {
            try {
                var reflections = new Reflections("assemble");
                var subclasses = reflections.getSubTypesOf(CommandUnit.class);
                List<CommandUnit> values = new ArrayList<>();
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
    public static CommandUnit fromOpcode(int opcode) {
        if (OPCODES == null) {
            try {
                var reflections = new Reflections("assemble");
                var subclasses = reflections.getSubTypesOf(CommandUnit.class);
                Map<Integer, CommandUnit> opcodes = new HashMap<>();
                for (var subclass : subclasses) {
                    CommandUnit _subclass = subclass.getConstructor().newInstance();
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
    public static CommandUnit fromMnemonic(String mnemonic) {
        if (MNEMONICS == null) {
            try {
                var reflections = new Reflections("assemble");
                var subclasses = reflections.getSubTypesOf(CommandUnit.class);
                Map<String, CommandUnit> mnemonics = new HashMap<>();
                for (var subclass : subclasses) {
                    CommandUnit _subclass = subclass.getConstructor().newInstance();
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

    public void execute(CentralProcessingUnit cpu, List<Integer> assemble.language.operands) {
        executor.execute(cpu, assemble.language.operands);
    }

    static public Instruction fromOpcode(int opcode) {
        return OPCODES.get(opcode);
    }

    static public Instruction fromMnemonic(String name) {
        return MNEMONICS.get(name);
    }
}*/