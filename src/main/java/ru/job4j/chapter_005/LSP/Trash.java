package ru.job4j.chapter_005.LSP;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    List<Food> trash = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (accept(food)) {
            trash.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        int percent = calculate(food);
        return percent >= 100;
    }

    @Override
    public List<Food> clear() {
        List<Food> copy = new ArrayList<>(trash);
        trash.clear();
        return copy;
    }
}
