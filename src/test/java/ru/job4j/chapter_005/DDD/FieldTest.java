package ru.job4j.chapter_005.DDD;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void gamePlay() {
        final Field field = new Field();
        StartGame game = new StartGame(
                new Player_1(new ConsoleMarkX(), field),
                new Player_2(new ConsoleMarkO(), field));
        game.getPlayer1().move(1, 1);
        game.getPlayer2().move(0, 1);
        game.getPlayer1().move(0, 2);
        game.getPlayer2().move(2, 2);
        String[][] result = field.field;
        assertThat(
                result, is(new String[][] {
                        {null, "O", "X"},
                        {null, "X", null},
                        {null, null, "O"}
                }
        ));
    }
}