package ru.job4j.chapter_001.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedArray<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;
    private Node<T> ref;
    private static int iteratorCount = 0;

    public LinkedArray(){
        head = new Node<T>(null,null,null);
        tail = new Node<T>(null,null,head);
        head.next = tail;
    }

    public void add(T value) {
        Node<T> temp = new Node<T>(value,tail,tail.previous);
        tail.previous = temp;
        temp.previous.next = temp;
        size++;
        iteratorCount++;
    }

    public T get(int index) {
        set(index);
        return ref.value;
    }

    private void set(int index){
        ref = head.next;
        for(int i = 0; i < index; i++){
            ref = ref.next;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node current = tail;
            private final int expectedModCount = iteratorCount;

            @Override
            public boolean hasNext() {
                failFast();
                return current != null;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                if (!hasNext()) { throw new NoSuchElementException(); }
                failFast();
                T item = (T) current.value;
                current = current.next;
                return item;
            }

            private void failFast() {
                if (expectedModCount < iteratorCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
