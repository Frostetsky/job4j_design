package ru.job4j.chapter_005.LSP.Products;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> shop = new ArrayList<>();
    private final float discount = 0.5f;

    @Override
    public void add(Food food) {
        if (accept(food)) {
            shop.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        int percent = calculate(food);
        if (percent > 25 && percent <= 75) {
            return true;
        } else if (percent > 75 && percent < 100) {
            food.setDiscount(discount);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> copy = new ArrayList<>(shop);
        shop.clear();
        return copy;
    }
}
