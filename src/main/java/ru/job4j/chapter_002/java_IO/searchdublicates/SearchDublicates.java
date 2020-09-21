package ru.job4j.chapter_002.java_IO.searchdublicates;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.SizeFileComparator;

import java.io.File;
import java.util.*;

public class SearchDublicates {
    public static Set<String> searchDuplicate(File catalog) {
        Set<String> dublicatefile = new HashSet<>();
        List<File> filesdirectory = (List<File>) FileUtils.listFiles(catalog, null, true);
        Collections.sort(filesdirectory, SizeFileComparator.SIZE_COMPARATOR);
        for (int i = 0; i < filesdirectory.size() - 1; i++) {
            if      (filesdirectory.get(i).getName().equals(filesdirectory.get(i + 1).getName()) &&
                    (FileUtils.sizeOf(filesdirectory.get(i)) == FileUtils.sizeOf(filesdirectory.get(i + 1)))) {

                dublicatefile.add(filesdirectory.get(i).getAbsolutePath());
                dublicatefile.add(filesdirectory.get(i + 1).getAbsolutePath());
            }
        }
        return dublicatefile;
    }

    public static void main(String[] args) {
        File catalog = new File("C:\\Users\\Nikita\\Test");
        SearchDublicates.searchDuplicate(catalog).forEach(System.out::println);
    }
}
