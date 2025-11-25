package language.format;

import assemble.Instruction;
import language.operands.Operands;
import language.IncorrectFormatException;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class FormatHandler {
    protected String registerRegex = "([rR]([0-9]|[12][0-9]|3[0-1]))";
    protected String const12Regex = "(([0-9]|1[0-9]{1,3}|20[0-4][0-7])|-([1-9]|1[0-9]{1,3}|20[0-4][0-8])|(0[xX]([0-9a-fA-F]|[1-9a-fA-F][0-9a-fA-F]{1,2})))";
    protected String const20Regex = "(([0-9]|[1-9][0-9]{1,4}|[1-4][0-9]{1,5}|5[0-2][0-4][0-2][0-8][0-7])|-([1-9]|[1-9][0-9]{1,4}|[1-4][0-9]{1,5}|5[0-2][0-4][0-2][0-8][0-8])|(0[xX]([0-9a-fA-F]|[1-9a-fA-F][0-9a-fA-F]{1,4})))";
    protected FormatHandler successor;
    protected String formatRegex;

    FormatHandler(Class<? extends Operands> operands) {
        List<String> operandRegexes = createOperandRegexes();
        StringBuilder regexBuilder = new StringBuilder().append("^( *)(");
        boolean isFirst = true;

        for (var instruction : Instruction.values()) {
            Class<? extends Operands> _operands =
                    (Class<? extends Operands>) ((ParameterizedType)instruction
                            .getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            if (operands == _operands) {
                if (!isFirst)
                    regexBuilder.append("|");

                regexBuilder
                        .append(instruction.getMnemonic().toUpperCase())
                        .append("|")
                        .append(instruction.getMnemonic().toLowerCase());
                isFirst = false;
            }
        }
        regexBuilder.append(")");

        for (var operandRegex : operandRegexes)
            regexBuilder.append("( +)").append(operandRegex);

        regexBuilder.append("( *)$");

        formatRegex = regexBuilder.toString();
    }

    public void setSuccessor(FormatHandler successor) {
        this.successor = successor;
    }

    protected abstract List<String> createOperandRegexes();

    public abstract int handleRequest(String request) throws IncorrectFormatException;
}
