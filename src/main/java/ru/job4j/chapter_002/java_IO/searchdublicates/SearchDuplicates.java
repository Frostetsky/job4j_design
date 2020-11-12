package ru.job4j.chapter_002.java_IO.searchdublicates;

import java.io.File;
import java.util.*;

public class SearchDuplicates {
    public static Set<String> searchDuplicate(File catalog) {
        // TODO сделать через HashSet, проверять условие дубликата при добавлении в Set
        return null;
    }

    public static void main(String[] args) {
        File catalog = new File("C:\\Users\\Nikita\\Test");
        SearchDuplicates.searchDuplicate(catalog).forEach(System.out::println);
    }
}
