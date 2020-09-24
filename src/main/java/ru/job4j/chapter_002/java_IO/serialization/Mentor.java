package ru.job4j.chapter_002.java_IO.serialization;

public class Mentor {
    private String name;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "name='" + name + '\'' +
                '}';
    }
}
