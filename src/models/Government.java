package models;

public enum Government {
    ANARCHY,
    COMMUNISM,
    MERITOCRACY,
    ETHNOCRACY;
    public static Government fromInt(int governmentNumber) {
        if (governmentNumber == 1) {
            return Government.ANARCHY;
        } else if (governmentNumber == 2) {
            return Government.COMMUNISM;
        } else if (governmentNumber == 3) {
            return Government.MERITOCRACY;
        } else {
            return Government.ETHNOCRACY;
        }
    }
}