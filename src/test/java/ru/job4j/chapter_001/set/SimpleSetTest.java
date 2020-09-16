package ru.job4j.chapter_001.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddElement() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("job4j");
        set.add("job5j");
        assertThat(set.get(1), is("job5j"));
    }

    @Test
    public void whenUniquenessOfElements() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(5); // is 3 element
        assertThat(set.get(0), is(1));
        assertThat(set.get(1), is(2));
        assertThat(set.get(2), is(3));
        assertThat(set.get(3), is(5));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void whenIterate() {
        SimpleSet<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void whenIsEmpty() {
        SimpleSet<Integer> set = new SimpleSet<>();
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.hasNext(), is(false));
    }
}