package ru.job4j.chapter_002.java_IO.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private static Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String[] strings = toString().split(System.lineSeparator());
        for (String element : strings) {
            if (element.contains("#") || element.isEmpty()) {
                continue;
            }
            String[] mapselement = element.split("=");
            values.put(mapselement[0],mapselement[1]);
        }
    }


    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        new Config("./src/main/java/ru/job4j/chapter_002/java_IO/config/app.properties").load();
    }
}