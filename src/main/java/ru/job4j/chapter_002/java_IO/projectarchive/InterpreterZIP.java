package ru.job4j.chapter_002.java_IO.projectarchive;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class InterpreterZIP {
    public static void main(String[] args) throws Exception {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            List<Path> files = Zip.findFiles(argZip);
            Zip zip = new Zip();
            zip.packFiles(
                    files.stream().map(Path::toFile).collect(Collectors.toList()),
                    new File(argZip.output())
            );
        }
    }
}
