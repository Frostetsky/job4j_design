package ru.job4j.chapter_002.java_IO.searchfilebycriterion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WriteFile {
    private List<File> files;
    private File result;

    public WriteFile(List<File> files, File result) {
        this.files = files;
        this.result = result;
    }

    public void writeInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(result))) {
            for (File file : files) {
                writer.write(file.getAbsolutePath());
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
