package ru.zavar.itmo.algo.dls;

import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.Node;

import java.util.*;

public final class DepthLimitedSearchAlgorithm {
    private static final Set<Node<?>> alreadyVisited = new HashSet<>();
    private static final List<Node<?>> path = new ArrayList<>();
    public static <T> Optional<Node<T>> search(Graph<T> graph, T startValue, T finishValue, int limit) {
        Node<T> start = graph.getNode(startValue).get();
        Node<T> finish = graph.getNode(finishValue).get();
        alreadyVisited.add(start);
        System.out.println("Посетили верщину: " + start.getValue());
        if (start == finish) {
            alreadyVisited.clear();
            return Optional.of(start);
        } else if (limit != 0) {
            for (Node<T> v : graph.getAdjNodes(start.getValue())) {
                if (!alreadyVisited.contains(v) && search(graph, v.getValue(), finishValue, limit - 1).isPresent()) {
                    path.add(v);
                    alreadyVisited.clear();
                    return Optional.of(start);
                }
            }
        }
        alreadyVisited.clear();
        return Optional.empty();
    }

    public static void trace(Node<?> start){
        path.add(start);
        if(path.size() == 1) {
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
