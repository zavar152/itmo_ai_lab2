package ru.zavar.itmo.bfs;

import ru.zavar.itmo.Graph;
import ru.zavar.itmo.Node;

import java.util.*;

public final class BreadthFirstSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Graph<T> graph, T value, T start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(graph.getNode(start).get());

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Посетили вершину: " + currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                trace(currentNode);
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                List<Node<T>> neighbors = graph.getAdjNodes(currentNode.getValue());
                Node<T> finalCurrentNode = currentNode;
                neighbors.forEach(tNode -> {
                    if(!alreadyVisited.contains(tNode))
                        tNode.setPrev(finalCurrentNode);
                });
                queue.addAll(neighbors);
                queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }

    private static void trace(Node<?> node){
        List<Node<?>> route = new ArrayList<>();
        while(node != null){
            route.add(node);
            node = node.getPrev();
        }
        Collections.reverse(route);
        System.out.print("Путь: ");
        StringBuilder path = new StringBuilder();
        route.forEach(node1 -> {
            path.append(node1.getValue());
            path.append(" -> ");
        });
        path.delete(path.length() - 3, path.length());
        System.out.println(path);
    }
}
