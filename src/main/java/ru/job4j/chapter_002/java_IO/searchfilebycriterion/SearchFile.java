package ru.job4j.chapter_002.java_IO.searchfilebycriterion;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

public class SearchFile {
    private static List<File> result = new ArrayList<>();

    private List<File> searchFiles(Predicate<File> predicate, File directory) {
        for (File fileEntry : directory.listFiles()) {
            if (fileEntry.isDirectory()) {
                searchFiles(predicate, fileEntry);
            } else {
                if (predicate.test(fileEntry)) {
                    result.add(fileEntry);
                }
            }
        }
        return result;
    }

    public List<File> searchByMask(String mask, File directory) {
        return searchFiles(file -> file.getName().endsWith(mask), directory);
    }

    public List<File> searchByName(String name, File directory) {
        return searchFiles(file -> file.getName().equals(name), directory);
    }

    public List<File> searchByRegexp(String regexp, File directory) {
        return searchFiles(file -> file.getName().matches(regexp), directory);
    }
}
