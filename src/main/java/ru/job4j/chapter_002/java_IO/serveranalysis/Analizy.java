package ru.job4j.chapter_002.java_IO.serveranalysis;

import java.io.*;
import java.util.*;

public class Analizy {

    private static final List<String> result = new ArrayList<>();

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            String lastline = null;
            int index = -1;
            while ((line = read.readLine()) != null) {
                index++;
                if (index == 0) {
                    lastline = line;
                }
                if (index == 0) {
                    continue;
                }
                Integer index1 = Integer.valueOf(line.split(" ")[0]);
                Integer lastindex = Integer.valueOf(lastline.split(" ")[0]);
                if ((index1 == 500 || index1 == 400) && (lastindex == 200 || lastindex == 300)) {
                    result.add(line.split(" ")[1]);
                }
                if ((lastindex == 500 || lastindex == 400) && (index1 == 200 || index1 == 300)) {
                    result.add(line.split(" ")[1]);
                }
                lastline = line;
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
