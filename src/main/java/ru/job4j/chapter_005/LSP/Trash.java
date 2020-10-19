package ru.job4j.chapter_005.LSP;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Trash implements Strategy {

    List<Food> trash = new ArrayList<>();

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
            if (percent >= 100) {
                trash.add(food);
                iterator.remove();
            }
        }
    }

    @Override
    public List<Food> findAll() {
        return trash;
    }
}
