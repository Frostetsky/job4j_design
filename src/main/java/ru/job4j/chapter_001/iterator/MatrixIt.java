package ru.job4j.chapter_001.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (row + 1 == data.length) {
            return column < data[row].length;
        }
        while (data.length > row && column == data[row].length) {
            column = 0;
            row++;
        }
        return data.length > row && data[row].length > column;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
