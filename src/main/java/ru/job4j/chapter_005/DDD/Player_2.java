package ru.job4j.chapter_005.DDD;

public class Player_2 implements Player {

    private Mark symbol;
    private static final Field fieldObject = Field.getField();

    public Player_2(Mark symbol) {
        this.symbol = symbol;
    }

    @Override
    public String[][] move(int row, int column) {
        fieldObject.field[row][column] = symbol.print();
        return fieldObject.field;
    }
}
