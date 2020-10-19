package ru.job4j.chapter_005.LSP;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Shop implements Strategy {

    private List<Food> shop = new ArrayList<>();
    private final float discount = 0.5f;

    @Override
    public void add(List<Food> stack) {
        Iterator<Food> iterator = stack.iterator();
        while (iterator.hasNext()) {
            Food food = iterator.next();
            LocalDate start = food.getCreateDate();
            LocalDate end = food.getExpiryDate();
            LocalDate now = LocalDate.now();
            long allDays = ChronoUnit.DAYS.between(start, end);
            long remainDays = ChronoUnit.DAYS.between(now, end);
            int percent = (int) (remainDays / (allDays / 100.0));
            if (percent > 25 && percent <= 75) {
                shop.add(food);
                iterator.remove();
            } else if (percent > 75 && percent < 100) {
                food.setDiscount(discount);
                shop.add(food);
            }
        }
    }

    @Override
    public List<Food> findAll() {
        return shop;
    }
}
