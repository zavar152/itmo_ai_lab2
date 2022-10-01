package ru.zavar.itmo.graph;

public class HeuristicNode<T> implements Comparable<HeuristicNode<T>> {
    private final int f;
    private final int g;
    private final int h;

    private final Node<T> node;

    public HeuristicNode(Node<T> node, int h) {
        this.node = node;
        this.h = h;
        this.g = 0;
        this.f = g + h;
    }

    public HeuristicNode(Node<T> node, int h, int g) {
        this.node = node;
        this.h = h;
        this.g = g;
        this.f = g + h;
    }

    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public T getValue() {
        return node.getValue();
    }

    public void setPrev(Node<T> prev) {
        node.setPrev(prev);
    }

    public Node<T> getPrev() {
        return node.getPrev();
    }

    public Node<T> getNode() {
        return node;
    }

    @Override
    public int compareTo(HeuristicNode<T> o) {
        return f - o.f;
    }

    @Override
    public String toString() {
        return "HeuristicNode{" +
                "value=" + node.getValue() +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                '}';
    }
}
