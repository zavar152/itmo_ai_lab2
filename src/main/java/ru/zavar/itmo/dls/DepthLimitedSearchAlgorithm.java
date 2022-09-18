package ru.zavar.itmo.dls;

import ru.zavar.itmo.Node;

import java.util.*;

public final class DepthLimitedSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Node<T> start, Node<T> target, int limit) {
        Stack<Node<T>> stack = new Stack<>();
        stack.add(start);
        Set<Node<?>> alreadyVisited = new HashSet<>();
        int depth = 0;
        while (!stack.isEmpty()) {
            if(depth <= limit) {
                Node<T> element = stack.pop();
                if (!alreadyVisited.contains(element)) {
                    depth++;
                    alreadyVisited.add(element);
                }
                if(element.equals(target)) {
                    alreadyVisited.clear();
                    trace(element);
                    return Optional.of(element);
                }
                List<Node<T>> neighbours = element.getNeighborsList();
                for (Node<T> n : neighbours) {
                    if (n != null && !alreadyVisited.contains(n)) {
                        stack.add(n);
                        n.setPrev(element);
                    }
                }
            } else {
                System.out.println("Путь не найден");
                return Optional.empty();
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
