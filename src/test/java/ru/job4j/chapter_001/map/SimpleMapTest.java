package ru.job4j.chapter_001.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {
    @Test
    public void whenAddInMap() {
        SimpleMap<Integer,String> map = new SimpleMap<>();
        map.insert(1, "Nikita");
        assertThat(map.get(1), is("Nikita"));
    }

    @Test
    public void whenDeleteInMap() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "Nikita");
        map.insert(2, "Mira");
        map.delete(1);
        assertThat(map.get(2), is("Mira"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCrashIterator() {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.insert(1, "Nikita");
        map.insert(2, "Mira");
        Iterator<SimpleMap.Node<Integer, String>> iterator = map.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            map.insert(3, "Dmitriy");
        }
    }

}