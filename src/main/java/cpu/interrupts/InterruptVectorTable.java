package cpu.interrupts;

import cpu.interrupts.exceptions.InterruptException;
import cpu.interrupts.handlers.InterruptHandler;
import operands.Operands;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.*;

public class InterruptVectorTable {
    private Map<Integer, InterruptHandler> table;

    public InterruptVectorTable() {
        Map<Integer, InterruptHandler> table = new HashMap<>();
        try {
            var reflections = new Reflections("cpu.interrupts");
            var subclasses = reflections.getSubTypesOf(InterruptHandler.class);

            for (var interruptHandlerClass : subclasses) {
                var interruptHandler = interruptHandlerClass.getConstructor().newInstance();

                var interfaces = interruptHandlerClass.getGenericInterfaces();
                if (interfaces.length == 0 || !(interfaces[0] instanceof ParameterizedType)) {
                    throw new IllegalStateException(
                            "InterruptHandler subclass must declare generic parameter <T>: " +
                                    interruptHandlerClass.getName()
                    );
                }

                var paramType = (ParameterizedType) interfaces[0];
                Class<? extends InterruptException> interruptException =
                        (Class<? extends InterruptException>) paramType.getActualTypeArguments()[0];

                int vector = interruptException.getConstructor(int.class, boolean.class, String.class)
                        .newInstance(0, false, "")
                        .getVector();

                table.put(vector, interruptHandler);
            }

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public InterruptHandler getInterruptHandler(int vector) {
        return table.get(vector);
    }
}
