package ru.job4j.chapter_005.TDD;

public class IncorrectOrOccupiedPositionException extends Exception {
    public IncorrectOrOccupiedPositionException(String message) {
        super(message);
    }
}
