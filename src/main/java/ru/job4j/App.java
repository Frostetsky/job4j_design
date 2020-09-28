package ru.job4j;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        App.filter(objects);
        App.filter(animals);
    }

    private static void filter(List<? super Animal> list) {
        System.out.println(list);
    }
}
