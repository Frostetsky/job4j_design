package ru.job4j.chapter_005.LSP.Products;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Storage {

    List<Food> wareHouse = new ArrayList<>();

    @Override
    public void add(Food food) {
        if (accept(food)) {
            wareHouse.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        int percent = calculate(food);
        return percent > 0 && percent <= 25;
    }

    @Override
    public List<Food> clear() {
        List<Food> copy = new ArrayList<>(wareHouse);
        wareHouse.clear();
        return copy;
    }
}
