package ru.job4j.chapter_005.DDD;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class ConsoleMarkXTest {
    @Test
    public void printX() {
        String out = new ConsoleMarkX().print();
        assertThat(out, is("X"));
    }
}