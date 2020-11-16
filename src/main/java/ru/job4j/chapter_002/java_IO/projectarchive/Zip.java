package ru.job4j.chapter_002.java_IO.projectarchive;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void zipRead(String source_dir, String zip_file, String ending) throws Exception {
        FileOutputStream fout = new FileOutputStream(zip_file);
        ZipOutputStream zout = new ZipOutputStream(fout);
        File fileSource = new File(source_dir);
        addDirectory(zout, fileSource, ending);
        zout.close();
        System.out.println("Zip файл создан!");
    }

    private void addDirectory(ZipOutputStream zout, File fileSource, String ending) throws Exception {
        File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                addDirectory(zout, file, ending);
                continue;
            }
            if (file.getName().endsWith(ending)) {
                continue;
            }
            System.out.println("Добавление файла <" + file.getName() + ">");
            FileInputStream fis = new FileInputStream(file);
            zout.putNextEntry(new ZipEntry(file.getPath()));
            byte[] buffer = new byte[4048];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zout.write(buffer, 0, length);
            }
            zout.closeEntry();
            fis.close();
        }
    }
}

