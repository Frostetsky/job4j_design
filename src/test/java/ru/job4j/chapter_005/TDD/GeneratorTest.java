package ru.job4j.chapter_005.TDD;

import org.junit.Test;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    public void whenProduceString() {
        String template = "Hello, My name is ${name}. My age is ${age}.";
        String expected = "Hello, My name is Nikita. My age is 21.";
        Map<String, String> keys = Map.of("name", "Nikita", "age", "21");
        Generator tg = new TemplateGenerator();
        String result = tg.produce(template, keys);
        assertThat(expected, is(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotCorrectKeysInMap() {
        String template = "Hello, I am ${name}. I have son. His job is ${job}.";
        String expected = "Hello, I am Nikita. I have son. His name is Aleksandr.";
        Map<String, String> keys = Map.of("name", "Nikita", "age", "21");
        Generator tg = new TemplateGenerator();
        String result = tg.produce(template, keys);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapHaveSuperfluousKeys() {
        String template = "Hello, I am ${name}. I have son. His job is ${job}.";
        String expected = "Hello, I am Nikita. I have son. His name is Aleksandr.";
        Map<String, String> keys = Map.of(
                "name", "Nikita",
                "age", "21",
                "email", "job4j@bk.ru");
        Generator tg = new TemplateGenerator();
        String result = tg.produce(template, keys);
    }
}