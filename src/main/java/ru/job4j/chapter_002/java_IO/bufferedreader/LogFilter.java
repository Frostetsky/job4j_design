package ru.job4j.chapter_002.java_IO.bufferedreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
           List<String> tempresult = reader.lines().collect(Collectors.toList());
           for (String element : tempresult) {
               String[] strings = element.split(" ");
               if (Integer.valueOf(strings[strings.length - 2]) == 404) {
                   result.add(element);
               }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("C:\\Users\\Nikita\\IdeaProjects\\job4j_design\\" +
                                       "src\\main\\java\\ru\\job4j\\chapter_002\\java_IO\\" +
                                       "bufferedreader\\log.txt");
        System.out.println(log);
    }
}
