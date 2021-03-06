package ru.job4j.chapter_002.java_IO.fileoutputstream;

import java.io.FileOutputStream;

public class MultiplicationTable {
    public static void main(String[] args) {
        try (FileOutputStream out =
                     new FileOutputStream("./src/main/java/ru/job4j/chapter_002/java_IO/fileoutputstream/multiplicationtable.txt")) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    out.write(Integer.toString(i * j).getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}