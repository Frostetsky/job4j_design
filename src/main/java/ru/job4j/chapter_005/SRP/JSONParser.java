package ru.job4j.chapter_005.SRP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.chapter_005.OCP.Parser;

import java.util.List;
import java.util.StringJoiner;

public class JSONParser implements Parser {
    @Override
    public String formatted(List<Employee> list) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (Employee employee : list) {
            Gson gson = new GsonBuilder().create();
            joiner.add(gson.toJson(employee));
        }
        return joiner.toString();
    }
}
