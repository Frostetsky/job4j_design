package ru.job4j.chapter_002.java_IO.projectarchive;

public class ArgZip {

    private final String[] args;
    private static final int dash = 45;
    private static final int d = 100;
    private static final int e = 101;
    private static final int o = 111;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        boolean validate = false;
        if (!directory().isEmpty() && !exclude().isEmpty() && !output().isEmpty()) {
            validate = true;
        }
        return validate;
    }

    public String directory() { // -d=c:\project\job4j\
        if (args[4].charAt(0) != dash && args[4].charAt(1) != d) {
            throw new IllegalArgumentException("Parameter -d is missing");
        }
        return args[4].split("=")[1];
    }

    public String exclude() { // -e=class
        if (args[5].charAt(0) != dash && args[5].charAt(1) != e) {
            throw new IllegalArgumentException("Parameter -e is missing");
        }
        return args[5].split("=")[1];
    }

    public String output() { // -o=project.zip
        if (args[6].charAt(0) != dash && args[6].charAt(1) != o) {
            throw new IllegalArgumentException("Parameter -o is missing");
        }
        return args[6].split("=")[1];
    }
}

// java -jar test.jar -d=C:\\Users\\Nikita\\Test -e=xml -o=C:\\Users\\Nikita\\Test.zip
