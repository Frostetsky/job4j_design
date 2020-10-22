package ru.job4j.chapter_005.SRP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HRFormat implements Formatted {
    @Override
    public String formatted(List<Employee> list) {
        List<String> join = new ArrayList<>();
        list.sort(Comparator.comparing(Employee::getSalary));
        for (Employee employee : list) {
            join.add(employee.getName() + " | " + employee.getSalary());
        }
        return join
                .stream()
                .collect(Collectors.joining(" ---- ", "{", "}"));
    }
}
