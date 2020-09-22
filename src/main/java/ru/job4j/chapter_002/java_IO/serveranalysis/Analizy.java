package ru.job4j.chapter_002.java_IO.serveranalysis;

import java.io.*;
import java.util.*;

public class Analizy {

    private static List<String> result = new ArrayList<>();

    public void unavailable(String source, String target) throws IOException {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(out::add);
            String[] elementlogs = out.toString().split(System.lineSeparator());
            List<Integer> times = new ArrayList<>();
            for (String element : elementlogs) {
                times.add(Integer.valueOf(element.split(" ")[0]));
            }
            int index = 0;
            for (String element : elementlogs) {
                String[] elementmaps = element.split(" ");
                if (elementmaps.length > 2) {
                    throw new IncorrectInitialDataException("�������� �������� ������");
                }
                Integer number = Integer.valueOf(elementmaps[0]);
                String time = elementmaps[1];
                if (index != 0) {
                    if ((number == 500 || number == 400) && (times.get(index - 1) == 200 || times.get(index - 1) == 300)) {
                        result.add(time);
                    }
                }
                if (index != 0) {
                    if ((times.get(index - 1) == 500 || times.get(index - 1) == 400) && (number == 200 || number == 300)) {
                        result.add(time);
                    }
                }
                index++;
            }
        } catch (IncorrectInitialDataException e) {
            e.printStackTrace();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(target));
        int index = 0;
        for (String time : result) {
            if (index == 0) {
                writer.write(time + " ");
                index++;
            } else if (index == 1) {
                writer.write(time);
                writer.write(System.lineSeparator());
                index = 0;
            }
        }
        writer.close();
    }


    public static void main (String[]args) throws IOException {
        String source = "./src/main/java/ru/job4j/chapter_002/java_IO/serveranalysis/server.log";
        String target = "./src/main/java/ru/job4j/chapter_002/java_IO/serveranalysis/result.log";
        new Analizy().unavailable(source, target);
    }
}
