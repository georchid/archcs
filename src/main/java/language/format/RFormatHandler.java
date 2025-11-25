package language.format;

import assemble.Instruction;
import memory.registers.Register32;
import operands.OperandsR;
import language.IncorrectFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RFormatHandler extends FormatHandler {
    public RFormatHandler() {
        super(OperandsR.class);
    }

    @Override
    protected List<String> createOperandRegexes() {
        List<String> operandRegexes = new ArrayList<>();
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
            instructionData |= Integer.decode(components[1].replaceAll("\\D+", "")) << (offset - Register32.ADDRESS_SIZE);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }
}
