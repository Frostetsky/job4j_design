package ru.job4j.chapter_005.SRP;

import java.util.GregorianCalendar;

public class StartProgram {
    private static MemStore store;

    public static void main(String[] args) {
        initialize();
        Generator generator = new HRReport(store);
        System.out.println(generator.generate(employee -> true));
    }


    private static void initialize() {
        store = new MemStore();
        store.add(new Employee(
                "Nikita",
                new GregorianCalendar(2020, 9, 13),
                new GregorianCalendar(2020, 10, 15),
                30000
        ));
        store.add(new Employee(
                "Mira",
                new GregorianCalendar(2020, 6, 17),
                new GregorianCalendar(2020, 8, 23),
                15000
        ));
    }
}
