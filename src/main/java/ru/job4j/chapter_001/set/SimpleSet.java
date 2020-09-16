package ru.job4j.chapter_001.set;

import ru.job4j.chapter_001.generic.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> {

    private SimpleArray<T> array = new SimpleArray<>();

    public void add(T value) {
        for (T values : array) {
            if (values.equals(value)) {
                return;
            }
        }
        array.add(value);
    }

    public T get(int index) {
        return array.get(index);
    }

    public Iterator iterator() {
        return array.iterator();
    }
}


