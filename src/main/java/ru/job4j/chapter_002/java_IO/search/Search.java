package ru.job4j.chapter_002.java_IO.search;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        File file = new File(args[0]);
        String[] enlargement = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            enlargement[i - 1] = args[i];
        }
        search(file, enlargement).forEach(System.out::println);
    }

    public static List<File> search(File root, String[] ext) {
        List<File> files = (List<File>) FileUtils.listFiles(root, ext, true);
        return files;
    }
}