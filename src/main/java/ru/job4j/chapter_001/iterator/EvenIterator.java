package ru.job4j.chapter_001.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (!interval()) {
            return false;
        }
        if (data[point] % 2 != 0) {
            point++;
        }
        return interval();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }

    private boolean interval() {
        return point < data.length;
    }
}
