package ru.job4j.chapter_001.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> node = detour(findBy(parent));
        if (detour(findBy(child)).isEmpty() && node.isPresent()) {
            node.get().children.add(new Node(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> detour(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Predicate<Node<E>> findBy(E value) {
        return eNode -> eNode.value.equals(value);
    }

    @Override
    public Predicate<Node<E>> isBinary() {
        return eNode -> eNode.children.size() > 2;
    }

}