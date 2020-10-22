package ru.job4j.chapter_005.SRP;

import java.util.function.Predicate;

public class BookkeepingReport implements Generator {
    private Store store;

    public BookkeepingReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new BookkeepingFormat().formatted(store.findBy(filter));
    }
}
