package ru.zavar.itmo.bfs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Node<T> {

    private final T value;
    private final Set<Node<T>> neighbors;
    private Node<T> prev = null;

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public T getValue() {
        return value;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Set<Node<T>> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void connect(Node<T> node) {
        if (this == node)
            throw new IllegalArgumentException("Петли не допустимы");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

}
