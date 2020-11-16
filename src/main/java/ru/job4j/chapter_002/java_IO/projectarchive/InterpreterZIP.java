package ru.job4j.chapter_002.java_IO.projectarchive;

public class InterpreterZIP {
    public static void main(String[] args) throws Exception {
        ArgZip arguments = new ArgZip(args);
        Zip zip = new Zip();
        if (arguments.valid()) {
            zip.zipRead(arguments.directory(), arguments.output(), arguments.exclude());
        }
    }
}
