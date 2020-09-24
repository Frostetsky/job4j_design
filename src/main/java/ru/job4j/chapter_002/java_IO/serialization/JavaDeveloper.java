package ru.job4j.chapter_002.java_IO.serialization;

import java.util.Arrays;

public class JavaDeveloper {
    private boolean isworking;
    private int age;
    private String name;
    private Mentor mentor;
    private String[] projects;

    public JavaDeveloper(boolean isworking, int age, String name, Mentor mentor, String[] projects) {
        this.isworking = isworking;
        this.age = age;
        this.name = name;
        this.mentor = mentor;
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "JavaDeveloper{" +
                "isworking=" + isworking +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", mentor=" + mentor +
                ", projects=" + Arrays.toString(projects) +
                '}';
    }
}
