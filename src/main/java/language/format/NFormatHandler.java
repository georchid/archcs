package language.format;

import assemble.Instruction;
import language.operands.OperandsN;
import language.IncorrectFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NFormatHandler extends FormatHandler {
    public NFormatHandler() {
        //super(Instruction.OperandsFormat.N);
        super(OperandsN.class);
    }

    @Override
    protected List<String> createOperandRegexes() {
        return new ArrayList<>();
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(formatRegex).matcher(request).matches()) {
            instructionData = Instruction.fromMnemonic(request.trim()).getOpcode() << (Instruction.SIZE - Instruction.OPCODE_SIZE);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }

    /*static final private String nFormatRegex;

    static {
        StringBuilder regexBuilder = new StringBuilder().append("^( *)(");
        boolean isFirst = true;
        for (var instruction : Instruction.values()) {
            if (instruction.getFormat() == Instruction.Format.N) {
                if (!isFirst)
                    regexBuilder.append("|");
                regexBuilder
                        .append(instruction.getMnemonic().toUpperCase())
                        .append("|")
                        .append(instruction.getMnemonic().toLowerCase());
                isFirst = false;
            }
        }
        regexBuilder.append(")( *)$");
        nFormatRegex = regexBuilder.toString();
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(nFormatRegex).matcher(request).matches()) {
            instructionData = Instruction.fromMnemonic(request.trim()).getOpcode() << (32 - Instruction.OPCODE_SIZE);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }*/
}
