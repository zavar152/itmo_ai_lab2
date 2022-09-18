package ru.zavar.itmo.bfs;

import java.util.*;

public final class BreadthFirstSearchAlgorithm {
    public static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Visited node with value: " + currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                trace(currentNode);
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                Set<Node<T>> neighbors = currentNode.getNeighbors();
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
        //Loop until node is null to reach start node
        //becasue start.prev == null
        while(node != null){
            route.add(node);
            node = node.getPrev();
        }
        //Reverse the route - bring start to the front
        Collections.reverse(route);
        //Output the route
        route.forEach(node1 -> System.out.println(node1.getValue()));
    }
}
