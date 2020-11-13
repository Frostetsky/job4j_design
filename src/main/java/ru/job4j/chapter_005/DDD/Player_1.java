package ru.job4j.chapter_005.DDD;

import java.io.ByteArrayOutputStream;

public class Player_1 implements Player {

    private Mark symbol;
    private Field field;

    public Player_1(Mark symbol, Field field) {
        this.symbol = symbol;
        this.field = field;
    }

    @Override
    public String[][] move(int row, int column) {
        field.field[row][column] = symbol.print();
        return field.field;
    }
}
