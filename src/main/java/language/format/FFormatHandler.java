package language.format;

import central_processing_unit.Flag;
import assemble.Instruction;
import operands.OperandsF;
import language.IncorrectFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FFormatHandler extends FormatHandler {
    public FFormatHandler() {
        //super(Instruction.OperandsFormat.F);
        super(OperandsF.class);
    }

    @Override
    protected List<String> createOperandRegexes() {
        List<String> operandRegexes = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean isFirst = true;

        for (var flag : Flag.values()) {
            if (!isFirst)
                builder.append("|");

            builder
                    .append(flag.getName().toLowerCase())
                    .append("|")
                    .append(flag.getName().toUpperCase());

            isFirst = false;
        }

        operandRegexes.add(builder.toString());
        return operandRegexes;
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(formatRegex).matcher(request).matches()) {
            String[] components = request.trim().split("( +)");
            int offset = Instruction.SIZE;
            instructionData = Instruction.fromMnemonic(components[0]).getOpcode() << (offset -= Instruction.OPCODE_SIZE);
            instructionData |= Flag.fromName(components[1]).getValue() << (offset -= Flag.SIZE);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }
    /*private final String fFormatRegex;

    public FFormatHandler() {
        StringBuilder regexBuilder = new StringBuilder().append("^( *)(");
        boolean isFirst = true;
        for (var instruction : Instruction.values()) {
            if (instruction.getFormat() == Instruction.Format.F) {
                if (!isFirst)
                    regexBuilder.append("|");
                regexBuilder
                        .append(instruction.getMnemonic().toUpperCase())
                        .append("|")
                        .append(instruction.getMnemonic().toLowerCase());
                isFirst = false;
            }
        }
        regexBuilder.append(")( +)(");
        isFirst = true;
        for (var flag : Flag.values()) {
            if (!isFirst)
                regexBuilder.append("|");
            regexBuilder
                    .append(flag.getName())
                    .append("|")
                    .append(flag.getName().toLowerCase());
            isFirst = false;
        }
        regexBuilder.append(")( *)$");
        fFormatRegex = regexBuilder.toString();
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(fFormatRegex).matcher(request).matches()) {
            String[] components = request.trim().split("( +)");
            int offset = Instruction.SIZE;
            instructionData = Instruction.fromMnemonic(components[0]).getOpcode() << (offset -= Instruction.OPCODE_SIZE);
            instructionData |= Flag.fromName(components[1]).getValue() << (offset -= Flag.SIZE);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }*/
}
