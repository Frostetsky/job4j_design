package ru.job4j.chapter_005.LSP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {

    private static List<Food> stack = new ArrayList<>();

    public static void main(String[] args) {
        init();
        Context context = new Context(new Shop()); // strategy
        context.addStore(stack);
        List<Food> resultCollection = context.returnCollection();
        resultCollection.forEach(System.out::println);
    }

    private static void init() {
        Food pasta = new Pasta(
                "Спаггетти",
                LocalDate.of(2020, 10,9),
                LocalDate.of(2020,10,29),
                150,
                0
        );
        Food cheese = new Cheese(
                "Пармезан",
                LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 29),
                235,
                0
        );
        Food sourCream = new SourCream(
                "Простоквашино",
                LocalDate.of(2020, 1, 23),
                LocalDate.of(2020, 2, 15),
                85,
                0
        );
        Food dumplings = new Dumplings(
                "Цезарь",
                LocalDate.of(2020, 2, 18),
                LocalDate.of(2020, 8, 18),
                550,
                0
        );
        Food bread = new Bread(
                "Багет",
                LocalDate.of(2020, 5, 16),
                LocalDate.of(2020, 6, 23),
                36,
                0
        );
        Food dumplingsRussian = new Dumplings(
                "Русские",
                LocalDate.of(2020, 3, 18),
                LocalDate.of(2020, 11, 15),
                550,
                0
        );
        stack.add(pasta);
        stack.add(cheese);
        stack.add(sourCream);
        stack.add(dumplings);
        stack.add(bread);
        stack.add(dumplingsRussian);
    }
}
