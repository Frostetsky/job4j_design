package ru.job4j.chapter_001.generic;

import org.junit.Test;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenAddElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(3);
        assertThat(simpleArray.get(0), is(3));
    }

    @Test
    public void getElement() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        Integer number = simpleArray.get(0);
        assertThat(number,is(1));
    }

    @Test
    public void whenReplaceElement() {
        SimpleArray<String> strings = new SimpleArray<>(5);
        strings.add("job");
        strings.add("5j");
        strings.setIndex(1,"4g");
        assertThat(strings.get(1), is("4g"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void invalidIndex() {
        SimpleArray<Integer> numbers = new SimpleArray<>(2);
        numbers.get(2);
    }

    @Test
    public void whenAddElementInEmptyCell() {
        SimpleArray<String> strings = new SimpleArray<>(3);
        strings.add("Nikita");
        strings.add("Petr");
        strings.add("Vlad");
        strings.remove(1);
        strings.add("Josh");
        assertThat(strings.get(2), is("Josh"));
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<Integer> numbers = new SimpleArray<>(5);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.remove(2);
        assertThat(numbers.get(2), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterate() {
        SimpleArray<Integer> numbers = new SimpleArray<>(3);
        numbers.add(1);
        numbers.add(0);
        numbers.add(-3);
        Iterator<Integer> iterator = numbers.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(0));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(-3));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test
    public void whenArrayIsEmpty() {
        SimpleArray<Integer> numbers = new SimpleArray<>();
        Iterator<Integer> iterator = numbers.iterator();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void DynamicsTest() {
        SimpleArray<Integer> numbers = new SimpleArray<>(2);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        assertThat(numbers.get(5), is(7));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenFailFastIterator() {
        SimpleArray<Integer> numbers = new SimpleArray<>();
        numbers.add(1);
        numbers.add(2);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            numbers.remove(1);
        }
    }
}