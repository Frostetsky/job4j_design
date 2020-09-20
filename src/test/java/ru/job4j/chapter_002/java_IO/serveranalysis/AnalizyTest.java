package ru.job4j.chapter_002.java_IO.serveranalysis;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void AnalizyServerTest() throws Exception {
        String source = "./src/test/java/ru/job4j/chapter_002/java_IO/serveranalysis/server.log";
        String target = "./src/test/java/ru/job4j/chapter_002/java_IO/serveranalysis/result.log";
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("300 10:56:01" + System.lineSeparator() +
                        "500 10:57:12" + System.lineSeparator() +
                        "400 10:58:15" + System.lineSeparator() +
                        "200 10:59:03" + System.lineSeparator() +
                        "400 11:01:05" + System.lineSeparator() +
                        "300 11:02:07");
        }
        new Analizy().unavailable(source,target);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:12 -- 10:59:03" +
                                            "11:01:05 -- 11:02:07"));
    }
}