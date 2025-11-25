package language.format;

import assemble.Instruction;
import memory.registers.Register32;
import language.operands.OperandsRRR;
import language.IncorrectFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RRRFormatHandler extends FormatHandler {
    public RRRFormatHandler() {
        //super(Instruction.OperandsFormat.RRR);
        super(OperandsRRR.class);
    }

    @Override
    protected List<String> createOperandRegexes() {
        List<String> operandRegexes = new ArrayList<>();
        operandRegexes.add(registerRegex);
        operandRegexes.add(registerRegex);
        operandRegexes.add(registerRegex);
        return operandRegexes;
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(formatRegex).matcher(request).matches()) {
            String[] components = request.trim().split("( +)");
            int offset = Instruction.SIZE;
            instructionData = Instruction.fromMnemonic(components[0]).getOpcode() << (offset -= Instruction.OPCODE_SIZE);
            instructionData |= Integer.decode(components[1].replaceAll("\\D+", "")) << (offset -= Register32.ADDRESS_SIZE);
            instructionData |= Integer.decode(components[2].replaceAll("\\D+", "")) << (offset -= Register32.ADDRESS_SIZE);
            instructionData |= Integer.decode(components[3].replaceAll("\\D+", "")) << (offset - Register32.ADDRESS_SIZE);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }

    /*static final private String rrrFormatRegex;

    static {
        StringBuilder regexBuilder = new StringBuilder().append("^( *)(");
        boolean isFirst = true;
        for (var instruction : Instruction.values()) {
            if (instruction.getFormat() == Instruction.Format.RRR) {
                if (!isFirst)
                    regexBuilder.append("|");
                regexBuilder.
                        append(instruction.getMnemonic().toUpperCase()).
                        append("|").
                        append(instruction.getMnemonic().toLowerCase());
                isFirst = false;
            }
        }
        regexBuilder
                .append(")( +)")
                .append(registerRegex)
                .append("( +)")
                .append(registerRegex)
                .append("( +)")
                .append(registerRegex)
                .append("( *)$");

        rrrFormatRegex = regexBuilder.toString();
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(rrrFormatRegex).matcher(request).matches()) {
            String[] components = request.trim().split("( +)");
            int offset = Instruction.SIZE;
            instructionData = Instruction.fromMnemonic(components[0]).getOpcode() << (offset -= Instruction.OPCODE_SIZE);
            instructionData |= Integer.decode(components[1].replaceAll("\\D+", "")) << (offset -= 5);
            instructionData |= Integer.decode(components[2].replaceAll("\\D+", "")) << (offset -= 5);
            instructionData |= Integer.decode(components[3].replaceAll("\\D+", "")) << (offset - 5);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }*/
}
