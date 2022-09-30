package ru.zavar.itmo.graph;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class Graph<T> {
    private final Map<Node<T>, List<Node<T>>> adjNodes;
    private final List<Node<T>> nodes;
    private final int[][] adjacencyMatrix;

    public Graph(Map<Node<T>, List<Node<T>>> adjNodes, List<Node<T>> nodes, int[][] adjacencyMatrix) {
        this.adjNodes = adjNodes;
        this.nodes = nodes;
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public List<Node<T>> getAdjNodes(T value) {
        return adjNodes.get(new Node<>(value));
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public int nodesCount() {
        return nodes.size();
    }

    public Optional<Node<T>> getNode(T value) {
        return nodes.stream().filter(tNode -> tNode.getValue().equals(value)).findFirst();
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
