package ru.job4j.chapter_002.java_IO.config;

import org.junit.Test;
import ru.job4j.chapter_002.java_IO.serveranalysis.IncorrectInitialDataException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() throws IncorrectInitialDataException {
        String path = "./src/main/java/ru/job4j/chapter_002/java_IO/config/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }
}