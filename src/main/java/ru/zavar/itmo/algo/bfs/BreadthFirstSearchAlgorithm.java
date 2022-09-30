package ru.zavar.itmo.algo.bfs;

import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.Node;

import java.util.*;

public final class BreadthFirstSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Graph<T> graph, T start, T finish) {
        System.out.println("Поиск в ширину: ");
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(graph.getNode(start).get());

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Посетили вершину: " + currentNode.getValue());

            if (currentNode.getValue().equals(finish)) {
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
            Node<?> temp = node.getPrev();
            node.setPrev(null);
            node = temp;
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
        System.out.println();
    }
}
