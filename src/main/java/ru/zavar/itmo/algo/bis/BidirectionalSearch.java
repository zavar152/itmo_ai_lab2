package ru.zavar.itmo.algo.bis;

import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.Node;

import java.util.*;

public final class BidirectionalSearch {
    private static <T> void bfs(Graph<T> graph, Queue<Node<T>> queue, Set<Node<T>> alreadyVisited, HashMap<Node<T>, Node<T>> parent) {
        Node<T> current = queue.poll();
        for (Node<T> i : graph.getAdjNodes(current.getValue())) {
            if (!alreadyVisited.contains(i)) {
                parent.put(i, current);
                alreadyVisited.add(i);
                queue.add(i);
            }
        }
    }

    private static <T> Optional<Node<T>> isIntersecting(Graph<T> graph, Set<Node<T>> sAlreadyVisited, Set<Node<T>> tAlreadyVisited) {
        for (Node<T> node : graph.getNodes()) {
            if (sAlreadyVisited.contains(node) && tAlreadyVisited.contains(node))
                return Optional.of(node);
        }
        return Optional.empty();
    }

    public static <T> Optional<Node<T>> search(Graph<T> graph, T start, T finish) {
        Node<T> s = graph.getNode(start).get();
        Node<T> t = graph.getNode(finish).get();
        Set<Node<T>> sAlreadyVisited = new HashSet<>();
        Set<Node<T>> tAlreadyVisited = new HashSet<>();

        HashMap<Node<T>, Node<T>> sParent = new HashMap<>();
        HashMap<Node<T>, Node<T>> tParent = new HashMap<>();

        Queue<Node<T>> sQueue = new LinkedList<>();
        Queue<Node<T>> tQueue = new LinkedList<>();

        Optional<Node<T>> intersectNode;
        sQueue.add(s);
        sAlreadyVisited.add(s);
        sParent.put(s, null);
        tQueue.add(t);
        tAlreadyVisited.add(t);
        tParent.put(t, null);

        while (!sQueue.isEmpty() && !tQueue.isEmpty()) {
            bfs(graph, sQueue, sAlreadyVisited, sParent);
            bfs(graph, tQueue, tAlreadyVisited, tParent);
            intersectNode = isIntersecting(graph, sAlreadyVisited, tAlreadyVisited);

            if (intersectNode.isPresent()) {
                trace(sParent, tParent, s, t, intersectNode.get());
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    private static <T> void trace(HashMap<Node<T>, Node<T>> sParent, HashMap<Node<T>, Node<T>> tParent, Node<T> s, Node<T> t, Node<T> intersectNode) {
        LinkedList<Node<T>> path = new LinkedList<>();
        path.add(intersectNode);
        Node<T> temp = intersectNode;
        while (!temp.equals(s)) {
            path.add(sParent.get(temp));
            temp = sParent.get(temp);
        }
        Collections.reverse(path);
        temp = intersectNode;
        while (!temp.equals(t)) {
            path.add(tParent.get(temp));
            temp = tParent.get(temp);
        }
        System.out.println("Путь:");
        StringBuilder pathBuilder = new StringBuilder();
        path.forEach(node1 -> {
            pathBuilder.append(node1.getValue());
            pathBuilder.append(" -> ");
        });
        pathBuilder.delete(pathBuilder.length() - 3, pathBuilder.length());
        System.out.println(pathBuilder);
    }
}
