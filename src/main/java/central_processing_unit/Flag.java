package central_processing_unit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Flag {
    ZERO(1),
    SIGN(2),
    CARRY(4),
    OVERFLOW(8),
    INTERRUPT(16),
    TRAP(32),
    SUPERVISOR(64);

    private final int value;
    private static final Map<Integer, Flag> VALUES;
    private static final Map<String, Flag> NAMES;
    public static int SIZE = 8;

    static {
        Map<Integer, Flag> values = new HashMap<>();
        Map<String, Flag> names = new HashMap<>();
        for (var flag : Flag.values()) {
            values.put(flag.getValue(), flag);
            names.put(flag.getName(), flag);
        }
        VALUES = Collections.unmodifiableMap(values);
        NAMES = Collections.unmodifiableMap(names);
    }

    Flag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return this.name().toLowerCase();
    }

    public static Flag fromValue(int value) {
        return VALUES.get(value);
    }

    public static Flag fromName(String name) {
        return NAMES.get(name.toLowerCase());
    }
}
