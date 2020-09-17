package ru.job4j.chapter_001.set;

import ru.job4j.chapter_001.generic.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> {

    private SimpleArray<T> array = new SimpleArray<>();

    public void add(T value) {
        if (contains(value)) {
            array.add(value);
        }
    }

    private boolean contains(T value) {
        for (T values : array) {
            if (Objects.equals(values,value)) {
                return false;
            }
        }
        return true;
    }

    public Iterator iterator() {
        return array.iterator();
    }
}


