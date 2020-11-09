package ru.job4j.chapter_002.java_IO.searchfilebycriterion;


import java.io.File;
import java.util.*;

// -d C:/Users/Nikita/Test -n *.txt -m -o result.txt
public class StartUI {
    private static final SearchFile searchFile = new SearchFile();

    public static void main(String[] args) {
        ValidateParameters vp = new ValidateParameters(args);
        final File directory = new File(vp.directory_D());
        final String criterion = vp.parameterSearch_M_F_R();
        final String name = vp.File_N();
        final String path = vp.resultFile_O();
        List<File> files = parameter(criterion, name, directory);
        WriteFile writeFile = new WriteFile(files, new File(path));
        writeFile.writeInFile();
    }

    private static List<File> parameter(String criterion, String name_mask_regexp, File directory) {
        return switch (criterion) {
            case "-m" -> searchFile.searchByMask(name_mask_regexp, directory);
            case "-f" -> searchFile.searchByName(name_mask_regexp, directory);
            case "-r" -> searchFile.searchByRegexp(name_mask_regexp, directory);
            default -> null;
        };
    }
}
