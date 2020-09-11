package ru.job4j.chapter_001.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LinkedArrayTest {
    @Test
    public void whenAddElement() {
        LinkedArray<Integer> linked = new LinkedArray<>();
        linked.add(1);
        linked.add(2);
        assertThat(linked.get(1), is(2));
    }

    @Test
    public void whenFirstNullElement() {
        LinkedArray<String> linked = new LinkedArray<>();
        assertNull(linked.get(0));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenFailFast() {
        LinkedArray<Integer> linked = new LinkedArray<>();
        linked.add(1);
        Iterator<Integer> iterator = linked.iterator();
        while (iterator.hasNext()) {
            Integer i  = iterator.next();
            linked.add(2);
        }
    }
}