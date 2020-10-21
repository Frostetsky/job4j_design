package ru.job4j.chapter_005.LSP;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Storage> storages = new ArrayList<>();

    public void init() {
        storages.add(new Shop());
        storages.add(new Trash());
        storages.add(new WareHouse());
    }

    public List<Storage> findAll() {
        return storages;
    }
}
