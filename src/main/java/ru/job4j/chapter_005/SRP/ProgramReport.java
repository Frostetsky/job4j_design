package ru.job4j.chapter_005.SRP;

import java.util.function.Predicate;

public class ProgramReport implements Generator {
    private Store store;

    public ProgramReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return new HTMLParser().formatted(store.findBy(filter));
    }
}
