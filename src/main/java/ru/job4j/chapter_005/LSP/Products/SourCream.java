package ru.job4j.chapter_005.LSP.Products;

import java.time.LocalDate;

public class SourCream extends Food {
    public SourCream(String name, LocalDate expiryDate, LocalDate createDate, double price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
