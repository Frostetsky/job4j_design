package ru.job4j.chapter_001.sort;

import java.util.*;
import java.util.stream.Collectors;

public class Department {

    private LinkedHashMap<String, TreeSet<String>> departments = new LinkedHashMap<>();


    public LinkedHashMap<String, TreeSet<String>> getDepartments() {
        return this.departments;
    }

    public TreeSet<String> divideOnSubDepartments(String department) {
        TreeSet<String> result = new TreeSet<>();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < department.length(); i++) {
            if (department.charAt(i) == '\\') {
                result.add(stringBuffer.toString());
            }
            stringBuffer.append(department.charAt(i));
        }
        result.add(department);
        result.remove(result.first());
        return result;
    }

    public void addDep(String department) {
        int indexOfFirstSlash = department.indexOf("\\");
        String key = (indexOfFirstSlash == -1) ? department : department.substring(0, indexOfFirstSlash);
        if (!this.departments.containsKey(key)) {
            this.departments.put(key, new TreeSet<>());
        }
        if (indexOfFirstSlash != -1) {
            this.departments.get(key).addAll(this.divideOnSubDepartments(department));
        }
    }

    public void descSort() {
        this.departments = this.departments.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
