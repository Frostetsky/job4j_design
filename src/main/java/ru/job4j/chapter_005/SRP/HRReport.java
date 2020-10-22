package ru.job4j.chapter_005.SRP;

import java.util.function.Predicate;

public class HRReport implements Generator {

    private Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new HRFormat().formatted(store.findBy(filter));
    }
}
