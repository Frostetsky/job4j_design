package ru.job4j.chapter_002.java_IO.search;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        File file = new File("./src");
        search(file, new String[] {"txt", "log", "properties"}).forEach(System.out::println);
    }

    public static List<File> search(File root, String[] ext) {
        List<File> files = (List<File>) FileUtils.listFiles(root, ext, true);
        return files;
    }
}