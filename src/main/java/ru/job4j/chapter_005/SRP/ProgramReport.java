package ru.job4j.chapter_005.SRP;

import ru.job4j.chapter_005.OCP.Parser;

import java.util.function.Predicate;

public class ProgramReport implements Generator {
    private Store store;
    private String prefix;

    public ProgramReport(Store store, String prefix) {
        this.store = store;
        this.prefix = prefix;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return ProgramReport.search(prefix).formatted(store.findBy(filter));
    }

    private static Parser search(String prefix) {
        if (prefix.equalsIgnoreCase("xml")) {
            return new XMLParser();
        } else if (prefix.equalsIgnoreCase("json")) {
            return new JSONParser();
        } else if (prefix.equalsIgnoreCase("html")) {
            return new HTMLParser();
        } else {
            try {
                throw new IllegalArgumentException("Unknown prefix - " + prefix);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
