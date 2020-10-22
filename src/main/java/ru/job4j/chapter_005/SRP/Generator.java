package ru.job4j.chapter_005.SRP;

import java.util.function.Predicate;

public interface Generator {
    String generate(Predicate<Employee> filter);
}
