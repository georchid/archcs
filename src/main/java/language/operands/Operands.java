package language.operands;

import assemble.Instruction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public abstract class Operands {
    public Operands(int operandsData) {
        disassemble(operandsData);
    }

    protected abstract void disassemble(int operandsData);

    public static Operands createForInstruction(Instruction instruction, int operandsData) {
        Class<? extends Operands> operands =
                (Class<? extends Operands>) ((ParameterizedType)instruction
                        .getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        try {
            return operands.getConstructor(int.class).newInstance(operandsData);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
