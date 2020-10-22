package ru.job4j.chapter_005.SRP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookkeepingFormat implements Formatted {

    private static final double EURO = 91.08;

    @Override
    public String formatted(List<Employee> list) {
        List<String> joiner = new ArrayList<>();
        for (Employee employee : list) {
            employee.setSalary(employee.getSalary() / EURO);
            joiner.add(employee.toString());
        }
        return joiner
                .stream()
                .collect(Collectors.joining(" ---- ", "{", "}"));
    }
}
