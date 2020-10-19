package ru.job4j.chapter_005.LSP;

import java.util.List;

public interface Strategy {

    void add(List<Food> stack);

    List<Food> findAll();
}
