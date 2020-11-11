package ru.job4j.chapter_005.DDD;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkO implements Mark {
    @Override
    public String print() {
        return "O";
    }
}
