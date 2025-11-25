package parsing.format;

import instructions.Instruction;
import operands.Operands;
import operands.OperandsC;
import parsing.IncorrectFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CFormatHandler extends FormatHandler {
    public CFormatHandler() {
        //super(Instruction.OperandsFormat.C);
        super(OperandsC.class);
    }

    @Override
    protected List<String> createOperandRegexes() {
        List<String> operandRegexes = new ArrayList<>();
        operandRegexes.add(const20Regex);
        return operandRegexes;
    }

    @Override
    public int handleRequest(String request) throws IncorrectFormatException {
        int instructionData = 0;
        if (Pattern.compile(formatRegex).matcher(request).matches()) {
            String[] components = request.toUpperCase().trim().split("( +)");
            int offset = Instruction.SIZE;
            instructionData = Instruction.fromMnemonic(components[0]).getOpcode() << (offset -= Instruction.OPCODE_SIZE);
            instructionData |= Integer.decode(components[1]) << (offset - 20);
        } else if (successor != null) {
            instructionData = successor.handleRequest(request);
        } else {
            throw new IncorrectFormatException("Incorrect format of instruction");
        }
        return instructionData;
    }
}
