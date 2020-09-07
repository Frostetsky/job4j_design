package ru.job4j.chapter_001.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        if (model != null) {
            this.array[index++] = model;
        }
    }

    public void setIndex(int position, T model) {
        Objects.checkIndex(position, array.length);
        this.array[position] = model;
    }

    @SuppressWarnings("unchecked")
    public T get(int position) {
        Objects.checkIndex(position, array.length);
        return (T) this.array[position];
    }

    public void remove(int position) {
        Objects.checkIndex(position, array.length);
        array[position] = null;
        System.arraycopy(array, position + 1, array, position , array.length - 1 - position );
        array[array.length - 1] = null;
        index--;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int iteratorindex = 0;

            @Override
            public boolean hasNext() {
                if (array[0] == null) {
                    return false;
                }
                return iteratorindex < array.length;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) array[iteratorindex++];
            }
        };
    }
}
