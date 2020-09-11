package ru.job4j.chapter_001.generic;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static int iteratorCount = 0;

    public SimpleArray() {
        this.array = new Object[DEFAULT_CAPACITY];
    }


    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        if (index == array.length) {
            Object[] newarray = new Object[array.length + 15];
            System.arraycopy(array, 0, newarray, 0, array.length);
            array = newarray;
        }
        this.array[index++] = model;
        iteratorCount++;
    }

    public void setIndex(int position, T model) {
        Objects.checkIndex(position, index);
        this.array[position] = model;
    }

    @SuppressWarnings("unchecked")
    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) this.array[position];
    }

    public void remove(int position) {
        Objects.checkIndex(position, index);
        array[position] = null;
        System.arraycopy(array, position + 1, array, position , array.length - 1 - position );
        array[array.length - 1] = null;
        index--;
        iteratorCount++;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int iteratorIndex = 0;
            private final int expectedModCount = iteratorCount;

            @Override
            public boolean hasNext() {
                failFast();
                return iteratorIndex < index;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                failFast();
                return (T) array[iteratorIndex++];
            }

            private void failFast() {
                if (expectedModCount < iteratorCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
