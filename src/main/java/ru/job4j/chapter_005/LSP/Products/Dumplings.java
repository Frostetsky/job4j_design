package ru.job4j.chapter_005.LSP.Products;

import java.time.LocalDate;

public class Dumplings extends Food {
    public Dumplings(String name, LocalDate expiryDate, LocalDate createDate, double price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
