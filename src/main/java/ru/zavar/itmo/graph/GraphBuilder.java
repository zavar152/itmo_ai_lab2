package ru.zavar.itmo.graph;

import java.util.*;

public final class GraphBuilder<T> {
    private final Map<Node<T>, List<Node<T>>> adjNodes = new HashMap<>();

    public GraphBuilder<T> addNode(T value) {
        adjNodes.putIfAbsent(new Node<>(value), new ArrayList<>());
        return this;
    }

    public GraphBuilder<T> addEdge(T value1, T value2) {
        Node<T> node1 = new Node<>(value1);
        Node<T> node2 = new Node<>(value2);
        adjNodes.get(node1).add(node2);
        adjNodes.get(node2).add(node1);
        return this;
    }

    public Graph<T> build() {
        List<Node<T>> nodes = adjNodes.keySet().stream().toList();
        int[][] adjacencyMatrix = new int[nodes.size()][nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            List<Node<T>> neighborsList = adjNodes.get(nodes.get(i));
            for (int j = 0; j < nodes.size(); j++) {
                if(neighborsList.contains(nodes.get(j))) {
                    adjacencyMatrix[i][j] = 1;
                }
            }
        }
//        for (int i = 0; i < nodes.size(); i++) {
//            for (int j = 0; j < nodes.size(); j++) {
//                System.out.printf("%5d ", adjacencyMatrix[i][j]);
//            }
//            System.out.println();
//        }
        return new Graph<>(adjNodes, nodes, adjacencyMatrix);
    }

}
