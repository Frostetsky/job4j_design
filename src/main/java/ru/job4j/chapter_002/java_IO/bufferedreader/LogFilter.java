package ru.job4j.chapter_002.java_IO.bufferedreader;

import java.io.*;
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

    public static void save(List<String> log, String file) {
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(file)))
        {
            for (String logs : log) {
                out.write(logs);
                out.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("./src/main/java/ru/job4j/chapter_002/java_IO/bufferedreader/log.txt");
        save(log, "./src/main/java/ru/job4j/chapter_002/java_IO/bufferedreader/404.txt");
    }
}
