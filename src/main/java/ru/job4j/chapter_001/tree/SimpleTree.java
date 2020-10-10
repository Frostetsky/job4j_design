package ru.job4j.chapter_001.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public interface SimpleTree<E> {

    boolean add(E parent, E child);

    Predicate<Node<E>> findBy(E value);

    Predicate<Node<E>> isBinary();

    Optional<Node<E>> detour(Predicate<Node<E>> predicate);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
