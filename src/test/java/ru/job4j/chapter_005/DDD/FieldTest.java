package ru.job4j.chapter_005.DDD;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void gamePlay() {
        Player p1 = new Player_1(new ConsoleMarkX());
        Player p2 = new Player_2(new ConsoleMarkO());
        p1.move(1, 1);
        p2.move(0, 1);
        p1.move(0, 2);
        p2.move(2, 2);
        String[][] result = Field.getField().field;
        assertThat(
                result, is(new String[][] {
                        {null, "O", "X"},
                        {null, "X", null},
                        {null, null, "O"}
                }
        ));
    }
}