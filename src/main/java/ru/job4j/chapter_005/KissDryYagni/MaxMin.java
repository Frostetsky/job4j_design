package ru.job4j.chapter_005.KissDryYagni;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T e = value.get(0);
        for (T v : value) {
            if (comparator.compare(e,v) > 0) {
                e = v;
            }
        }
        return e;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}
