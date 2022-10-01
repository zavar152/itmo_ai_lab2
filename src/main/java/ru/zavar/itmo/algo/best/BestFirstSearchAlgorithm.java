package ru.zavar.itmo.algo.best;

import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.HeuristicNode;
import ru.zavar.itmo.graph.Node;

import java.util.*;

public final class BestFirstSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Graph<T> graph, T start, T finish) {
        System.out.println("Поиск по первому наилучшему соответствию: ");
        PriorityQueue<HeuristicNode<T>> queue = new PriorityQueue<>();
        queue.add(new HeuristicNode<>(graph.getNode(start).get(), 0));

        HeuristicNode<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            System.out.println("Посетили вершину: " + currentNode.getValue());

            if (currentNode.getValue().equals(finish)) {
                trace(currentNode.getNode());
                return Optional.of(currentNode.getNode());
            } else {
                alreadyVisited.add(currentNode.getNode());
                List<Node<T>> neighbors = graph.getAdjNodes(currentNode.getValue());
                HeuristicNode<T> finalCurrentNode = currentNode;
                neighbors.forEach(tNode -> {
                    if(!alreadyVisited.contains(tNode))
                        tNode.setPrev(finalCurrentNode.getNode());
                    queue.add(new HeuristicNode<>(tNode, graph.getHeuristicOf(tNode)));
                });
                for(Node<T> node : alreadyVisited) {
                    Optional<HeuristicNode<T>> any = queue.stream().filter(tHeuristicNode -> tHeuristicNode.getNode().equals(node)).findAny();
                    any.ifPresent(queue::remove);
                }
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
