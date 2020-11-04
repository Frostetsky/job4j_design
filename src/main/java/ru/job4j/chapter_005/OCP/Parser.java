package ru.job4j.chapter_005.OCP;

import ru.job4j.chapter_005.SRP.Employee;

import java.util.List;

public interface Parser {
    String formatted(List<Employee> employees);
}
