package ru.job4j.chapter_004.CacheSoftReference;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Cache cache = new Cache("./src/main/java/ru/job4j/chapter_004/CacheSoftReference");
        String content = cache.getContent("Key1.txt");
        System.out.println(content);
    }
}
