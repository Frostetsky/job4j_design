package ru.job4j.chapter_002.java_IO.projectarchive;

import ru.job4j.chapter_002.java_IO.search.Search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) throws IOException {
        List<Path> paths;
        for (File source : sources) {
            paths = Search.search(Paths.get(source.getAbsolutePath()), "xml");
            for (Path path : paths) {
                if (path.getFileName().equals(source.getName())) {
                    continue;
                }
                packSingleFile(source, target);
            }
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> copyFile(String directory) {
        List<File> result = new ArrayList<>();
        File file = new File(directory);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException();
        }
        try {
            result = Files.walk(Paths.get(directory))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
            return result;
        }

        public static void main(String[] args) throws IOException {
            ArgZip argzip = new ArgZip(args);
            Zip zip = new Zip();
            List<File> files = zip.copyFile(argzip.directory());
            new Zip().packFiles(
                    files,
                    new File(argzip.output())
            );
        }
}

