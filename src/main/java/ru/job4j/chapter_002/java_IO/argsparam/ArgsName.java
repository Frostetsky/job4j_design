package ru.job4j.chapter_002.java_IO.argsparam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();
    private static final int dash = 45;

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            String clearline = arg.substring(1);
            if (arg.charAt(0) != dash ) {
                throw new IllegalArgumentException();
            }
            String[] element = clearline.split("=");
            System.out.println(Arrays.toString(element));
            if (element.length > 2) {
                throw new IllegalArgumentException();
            }
            values.put(element[0],element[1]);
        }

    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
