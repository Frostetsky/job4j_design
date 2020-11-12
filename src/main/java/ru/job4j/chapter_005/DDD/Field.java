package ru.job4j.chapter_005.DDD;

public final class Field {
    private static Field fieldSingle;
    String[][] field = new String[3][3];

    private Field() {
    }

    /**
     * Pattern Singleton for play_field
     * @return Singleton Field
     */
    public static Field getField() {
        if (fieldSingle == null) {
            fieldSingle = new Field();
        }
        return fieldSingle;
    }

    public boolean isContinue() {
        // TODO logic
        return true;
    }

    public boolean isWin() {
        // TODO logic
        return true;
    }
}
