package ru.job4j.chapter_005.LSP;

import java.util.List;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void addStore(List<Food> stack) {
        strategy.add(stack);
    }

    public List<Food> returnCollection() {
        return strategy.findAll();
    }
}
