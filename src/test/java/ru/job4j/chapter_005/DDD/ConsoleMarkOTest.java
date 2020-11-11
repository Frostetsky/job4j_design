package ru.job4j.chapter_005.DDD;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConsoleMarkOTest {
    @Test
    public void printO() {
        String out = new ConsoleMarkO().print();
        assertThat(out, is("O"));
    }
}