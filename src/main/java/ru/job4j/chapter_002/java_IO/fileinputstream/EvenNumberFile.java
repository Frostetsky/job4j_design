package ru.job4j.chapter_002.java_IO.fileinputstream;

import java.io.FileInputStream;

public class EvenNumberFile {

    public static void main(String[] args) {
        try (FileInputStream in =
                     new FileInputStream("./src/main/java/ru/job4j/chapter_002/java_IO/fileinputstream/even.txt"))
        {
            StringBuilder builder = new StringBuilder();
            int read;
            while (( read = in.read()) != -1) {
                builder.append((char) read);
            }

            String[] lines = builder.toString().split(System.lineSeparator());
            for (String line : lines) {
                if (Integer.valueOf(line) % 2 == 0) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
