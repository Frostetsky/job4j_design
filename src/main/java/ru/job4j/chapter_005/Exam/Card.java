package ru.job4j.chapter_005.Exam;

public abstract class Card {
    private String description;

    public Card(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
