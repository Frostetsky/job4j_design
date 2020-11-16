package ru.job4j.chapter_002.java_IO.searchdublicates;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

public class SearchDuplicates {
    private static Map<Long, File> duplicates = new HashMap<>();
    private static Set<File> result = new HashSet<>();

    public static Set<File> searchDuplicate(File catalog) {
        for (File file : Objects.requireNonNull(catalog.listFiles())) {
            if (file.isDirectory()) {
                searchDuplicate(file);
            } else {
                long sizeFile = FileUtils.sizeOf(file);
                if (duplicates.containsKey(sizeFile) && duplicates.get(sizeFile).getName().equals(file.getName())) {
                    result.add(file);
                    result.add(duplicates.get(sizeFile));
                } else {
                    duplicates.put(sizeFile, file);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        File catalog = new File("C:\\Users\\Nikita\\Test");
        SearchDuplicates.searchDuplicate(catalog).forEach(System.out::println);
    }
}
