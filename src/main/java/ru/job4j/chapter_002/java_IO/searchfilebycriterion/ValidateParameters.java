package ru.job4j.chapter_002.java_IO.searchfilebycriterion;

public final class ValidateParameters {
    private String[] args;

    public ValidateParameters(String[] args) {
        this.args = args;
    }


    public String directory_D() {
        if (!args[0].equals("-d") || args[1].isEmpty()) {
            error();
        }
        return args[1];
    }

    public String File_N() {
        if (!args[2].equals("-n") || args[3].isEmpty()) {
            error();
        }
        return args[3].split("\\.")[1];
    }

    public String parameterSearch_M_F_R() {
        if (args[4].isEmpty()) {
            error();
        }
        return args[4];
    }

    public String resultFile_O() {
        if (!args[5].equals("-o")) {
            error();
        }
        return args[6];
    }

    private void error() {
        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
