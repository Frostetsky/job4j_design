package ru.job4j.chapter_002.java_IO.projectarchive;

import java.io.IOException;

public class ArgZip {

    private final String[] args;
    private static final int dash = 45;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() { // java -jar pack.jar
        boolean validate = true;
        if (!(args[2].contains(".jar")) && !(args[0].contains("java")) && !(args[1].contains("-jar"))) {
            validate = false;
        }
        return validate;
    }

    public String directory() { // -d=c:\project\job4j\
        if (args[3].charAt(0) != dash) {
            throw new IllegalArgumentException();
        }
        return args[3].split("=")[1];
    }

    public String exclude() throws IOException { // -e=class
        if (args[4].charAt(0) != dash) {
            throw new IllegalArgumentException();
        }
        return args[4].split("=")[1];
    }

    public String output() { // -o=project.zip
        if (args[5].charAt(0) != dash) {
            throw new IllegalArgumentException();
        }
        return args[5].split("=")[1];
    }
}

// java -jar test.jar -d=C:\\Users\\Nikita\\IdeaProjects\\Test -e=xml -o=C:\\Users\\Nikita\\IdeaProjects\\Test.zip
