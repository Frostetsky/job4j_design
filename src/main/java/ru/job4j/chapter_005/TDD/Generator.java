package ru.job4j.chapter_005.TDD;

import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> args);
}
