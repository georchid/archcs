package code.format;

import code.commands.Instruction;
import risc.memory.registers.Register32;
import code.operands.three.OperandsRRC;
import code.IncorrectFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RRCFormatHandler extends FormatHandler {
    public RRCFormatHandler() {
        super(OperandsRRC.class);
    }

    @Override
    protected List<String> createOperandRegexes() {
        List<String> operandRegexes = new ArrayList<>();
        operandRegexes.add(registerRegex);
        operandRegexes.add(registerRegex);
        operandRegexes.add(const12Regex);
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
            instructionData |= Integer.decode(components[3]) << (offset - 12);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }

    /*static final private String rrcFormatRegex;

    static {
        StringBuilder regexBuilder = new StringBuilder().append("^( *)(");
        boolean isFirst = true;
        for (var instruction : Instruction.values()) {
            if (instruction.getFormat() == Instruction.Format.RRC) {
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
                .append(const12Regex)
                .append("( *)$");

        rrcFormatRegex = regexBuilder.toString();
    }

    // TODO
    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(rrcFormatRegex).matcher(request).matches()) {
            String[] components = request.trim().split("( +)");
            int offset = Instruction.SIZE;
            instructionData = Instruction.fromMnemonic(components[0]).getOpcode() << (offset -= Instruction.OPCODE_SIZE);
            instructionData |= Integer.decode(components[1].replaceAll("\\D+", "")) << (offset -= 5);
            instructionData |= Integer.decode(components[2].replaceAll("\\D+", "")) << (offset -= 5);
            instructionData |= Integer.decode(components[3]) << (offset - 12);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }*/
}
