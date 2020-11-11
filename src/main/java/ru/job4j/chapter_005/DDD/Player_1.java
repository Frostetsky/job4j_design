package ru.job4j.chapter_005.DDD;

import java.io.ByteArrayOutputStream;

public class Player_1 implements Player {

    private Mark symbol;
    private static final Field fieldObject = Field.getField();

    public Player_1(Mark symbol) {
        this.symbol = symbol;
    }

    @Override
    public String[][] move(int row, int column) {
        fieldObject.field[row][column] = symbol.print();
        return fieldObject.field;
    }
}
