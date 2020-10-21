package ru.job4j.chapter_005.LSP;

import java.util.List;

public class Context {
    Storage strategy;

    public Context(Storage strategy) {
        this.strategy = strategy;
    }

    public void addStore(Food food) {
        strategy.add(food);
    }

    public boolean acceptStore(Food food) {
        return strategy.accept(food);
    }

    public List<Food> returnCollection() {
        return strategy.clear();
    }
}
