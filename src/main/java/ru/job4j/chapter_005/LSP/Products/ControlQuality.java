package ru.job4j.chapter_005.LSP.Products;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlQuality {

    private final List<Storage> storages = new ArrayList<>();
    private final List<Food> foods = new ArrayList<>();

    public void init() {
        storages.add(new Shop());
        storages.add(new Trash());
        storages.add(new WareHouse());
    }

    public List<Storage> findAll() {
        return storages;
    }

    public void resort() {
        for (Storage storage : storages) {
            foods.addAll(storage.clear());
        }
        for (Food food : foods) {
            Program.distribute(food);
        }
    }
}
