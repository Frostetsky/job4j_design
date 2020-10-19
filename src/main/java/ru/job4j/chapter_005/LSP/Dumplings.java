package ru.job4j.chapter_005.LSP;

import java.time.LocalDate;
import java.util.Calendar;

public class Dumplings extends Food {
    public Dumplings(String name, LocalDate expiryDate, LocalDate createDate, double price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
