package ru.zavar.itmo.graph;

import java.util.*;

public final class Graph<T> {
    private final Map<Node<T>, List<Node<T>>> adjNodes;
    private final List<Node<T>> nodes;
    private final int[][] adjacencyMatrix;
    private final Map<Node<T>, Integer> heuristic;
    private final Map<AbstractMap.SimpleEntry<Node<T>, Node<T>>, Integer> distance;

    public Graph(Map<Node<T>, List<Node<T>>> adjNodes, List<Node<T>> nodes, int[][] adjacencyMatrix,
                 Map<Node<T>, Integer> heuristic, Map<AbstractMap.SimpleEntry<Node<T>, Node<T>>, Integer> distance) {
        this.adjNodes = adjNodes;
        this.nodes = nodes;
        this.adjacencyMatrix = adjacencyMatrix;
        this.heuristic = heuristic;
        this.distance = distance;
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

    public Integer getHeuristicOf(Node<T> node) {
        return heuristic.get(node);
    }

    public Integer getDistance(Node<T> node1, Node<T> node2) {
        return distance.get(new AbstractMap.SimpleEntry<>(node1, node2));
    }

    public Optional<Node<T>> getNode(T value) {
        return nodes.stream().filter(tNode -> tNode.getValue().equals(value)).findFirst();
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
