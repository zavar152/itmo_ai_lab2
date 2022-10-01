package ru.zavar.itmo.graph;

public class HeuristicNode<T> extends Node<T> implements Comparable<HeuristicNode<T>> {
    private final int f;
    private final int g;
    private final int h;

    public HeuristicNode(T value, int h) {
        super(value);
        this.h = h;
        this.g = 0;
        this.f = g + h;
    }

    public HeuristicNode(T value, int h, int g) {
        super(value);
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

    @Override
    public int compareTo(HeuristicNode<T> o) {
        return f - o.f;
    }

    @Override
    public String toString() {
        return "HeuristicNode{" +
                "value=" + super.getValue() +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                '}';
    }
}
