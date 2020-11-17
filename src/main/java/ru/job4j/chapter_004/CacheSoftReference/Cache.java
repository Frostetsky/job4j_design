package ru.job4j.chapter_004.CacheSoftReference;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private static Map<String, SoftReference<String>> cache = new HashMap<>();
    private String directory;

    public Cache(String directory) {
        this.directory = directory;
    }

    public String getContent(String fileName) throws IOException {
        String content = "";
        if (cache.containsKey(fileName)) {
            content = cache.get(fileName).get();
            if (content == null) {
                content = reader(fileName);
                put(fileName, content);
            }
        } else {
            content = reader(fileName);
            put(fileName, content);
        }
        return content;
    }

    public void put(String fileName, String content) {
        cache.put(fileName, new SoftReference<>(content));
    }

    private String reader(String fileName) throws IOException {
        Path path = Path.of(directory, fileName);
        File file = path.toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }
        return String.join(System.lineSeparator(), Files.readAllLines(path));
    }
}
