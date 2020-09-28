package ru.job4j.chapter_002.java_IO.serveranalysis;

import java.io.*;
import java.util.*;

public class Analizy {

    private static final List<String> result = new ArrayList<>();
    private static boolean foundError = false;

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = read.readLine()) != null) {
                Integer index1 = Integer.valueOf(line.split(" ")[0]);
                if ((index1 == 500 || index1 == 400) && !foundError) {
                    result.add(line.split(" ")[1]);
                    foundError = true;
                }
                if (foundError && (index1 == 200 || index1 == 300)) {
                    result.add(line.split(" ")[1]);
                    foundError = false;
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

    public static void main (String[]args) {
        String source = "./src/main/java/ru/job4j/chapter_002/java_IO/serveranalysis/server.log";
        String target = "./src/main/java/ru/job4j/chapter_002/java_IO/serveranalysis/result.log";
        new Analizy().unavailable(source, target);
    }
}
