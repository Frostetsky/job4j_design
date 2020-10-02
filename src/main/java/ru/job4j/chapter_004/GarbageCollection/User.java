package ru.job4j.chapter_004.GarbageCollection;

public class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Clear by finalize");
    }
}
