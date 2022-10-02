package ru.zavar.itmo.algo.dfs;

import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.Node;

import java.util.*;

public final class DepthFirstSearchAlgorithm {
    private static final Set<Node<?>> alreadyVisited = new HashSet<>();
    private static final List<Node<?>> path = new ArrayList<>();

    public static <T> Optional<Node<T>> search(Graph<T> graph, T startValue, T finishValue) {
        Optional<Node<T>> tNode = search0(graph, startValue, finishValue);
        tNode.ifPresent(DepthFirstSearchAlgorithm::trace);
        return tNode;
    }

    private static <T> Optional<Node<T>> search0(Graph<T> graph, T startValue, T finishValue) {
        System.out.println("Поиск в глубину: ");
        Node<T> start = graph.getNode(startValue).get();
        Node<T> finish = graph.getNode(finishValue).get();
        alreadyVisited.add(start);
        System.out.println("Посетили верщину: " + start.getValue());
        if (start == finish) {
            alreadyVisited.clear();
            return Optional.of(start);
        } else {
            for (Node<T> v : graph.getAdjNodes(start.getValue())) {
                if (!alreadyVisited.contains(v) && search0(graph, v.getValue(), finishValue).isPresent()) {
                    path.add(v);
                    alreadyVisited.clear();
                    return Optional.of(start);
                }
            }
        }
        alreadyVisited.clear();
        return Optional.empty();
    }

    private static void trace(Node<?> start) {
        path.add(start);
        if (path.size() == 1) {
            System.out.println("Путь не найден");
            return;
        }
        Collections.reverse(path);
        System.out.print("Путь: ");
        StringBuilder pathBuilder = new StringBuilder();
        path.forEach(node1 -> {
            pathBuilder.append(node1.getValue());
            pathBuilder.append(" -> ");
        });
        pathBuilder.delete(pathBuilder.length() - 3, pathBuilder.length());
        System.out.println(pathBuilder);
        path.clear();
        System.out.println();
    }
}
