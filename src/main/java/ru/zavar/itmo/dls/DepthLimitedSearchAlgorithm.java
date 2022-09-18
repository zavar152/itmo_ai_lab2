package ru.zavar.itmo.dls;

import ru.zavar.itmo.Node;

import java.util.*;

public final class DepthLimitedSearchAlgorithm {
    private static final Set<Node<?>> alreadyVisited = new HashSet<>();
    private static final List<Node<?>> path = new ArrayList<>();
    public static <T> Optional<Node<T>> search(Node<T> start, Node<T> finish, int limit) {
        alreadyVisited.add(start);
        if (start == finish) {
            alreadyVisited.clear();
            return Optional.of(start);
        } else if (limit != 0) {
            for (Node<T> v : start.getNeighbors()) {
                if (!alreadyVisited.contains(v) && search(v, finish, limit - 1).isPresent()) {
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
    }
}
