package ru.job4j.chapter_002.java_IO.file;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Nikita\\IdeaProjects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File subfile : file.listFiles()) {
            long size = FileUtils.sizeOfDirectory(subfile);
            System.out.println("Name folder: " + subfile.getName() + " || Size directory: " + size);
        }
    }
}
