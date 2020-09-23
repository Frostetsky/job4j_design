package ru.job4j.chapter_002.java_IO.serveranalysis;

import java.io.*;
import java.util.*;

public class Analizy {

    private static List<String> result = new ArrayList<>();

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            List<String> times = new ArrayList<>();
            while ((line = read.readLine()) != null) {
                times.add(line);
            }
            for (int index = 0; index < times.size(); index++) {
                if (index == 0) {
                    continue;
                }
                Integer index1 = Integer.valueOf(times.get(index).split(" ")[0]);
                Integer index2 = Integer.valueOf(times.get(index - 1).split(" ")[0]);
                if ((index1 == 500 || index1 == 400) && (index2 == 200 || index2 == 300)) {
                    result.add(times.get(index).split(" ")[1]);
                }
                if ((index2 == 500 || index2 == 400) && (index1 == 200 || index1 == 300)) {
                    result.add(times.get(index).split(" ")[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main (String[]args) throws IOException {
        String source = "./src/main/java/ru/job4j/chapter_002/java_IO/serveranalysis/server.log";
        String target = "./src/main/java/ru/job4j/chapter_002/java_IO/serveranalysis/result.log";
        new Analizy().unavailable(source, target);
    }
}
