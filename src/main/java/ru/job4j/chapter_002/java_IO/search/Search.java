package ru.job4j.chapter_002.java_IO.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0 || args[1].isEmpty()) {
            throw new IllegalArgumentException();
        }
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }


    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}