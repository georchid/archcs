package assemble.language;

import org.reflections.Reflections;
import assemble.language.format.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Parser {
    private final FormatHandler handler;

    public Parser() {
        List<FormatHandler> handlerList = new ArrayList<>();

        try {
            var reflections = new Reflections("assemble.language.format");
            var subclasses = reflections.getSubTypesOf(FormatHandler.class);
            for (var subclass : subclasses) {
                handlerList.add(subclass.getConstructor().newInstance());
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }

        for (int index = 0; index < handlerList.size() - 1; ++index)
            handlerList.get(index).setSuccessor(handlerList.get(index + 1));

        handler = handlerList.get(0);
    }

    public int parse(String line) throws IncorrectFormatException {
        return handler.handleRequest(line);
    }
}
