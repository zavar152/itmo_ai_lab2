package ru.zavar.itmo.dls;

import ru.zavar.itmo.Node;

import java.util.*;

public final class DepthLimitedSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Node<T> start, Node<T> target, int limit) {
        Stack<Node<T>> stack = new Stack<>();
        stack.add(start);
        Set<Node<?>> alreadyVisited = new HashSet<>();
        StringBuilder path = new StringBuilder();
        int depth = 0;
        while (!stack.isEmpty()) {
            if(depth <= limit) {
                Node<T> element = stack.pop();
                if (!alreadyVisited.contains(element)) {
                    path.append(element.getValue());
                    path.append(" -> ");
                    depth++;
                    System.out.println(path);
                    alreadyVisited.add(element);
                }
                if(element.equals(target)) {
                    alreadyVisited.clear();
                    path.delete(path.length() - 3, path.length());
                    System.out.print("Путь: ");
                    System.out.println(path);
                    return Optional.of(element);
                }
                List<Node<T>> neighbours = element.getNeighborsList();
                for (Node<T> n : neighbours) {
                    if (n != null && !alreadyVisited.contains(n)) {
                        stack.add(n);
                    }
                }
            } else {
                System.out.println("Путь не найден");
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
