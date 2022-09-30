package ru.zavar.itmo.ids;

import ru.zavar.itmo.Graph;
import ru.zavar.itmo.Node;
import ru.zavar.itmo.dls.DepthLimitedSearchAlgorithm;

import java.util.Optional;

public final class IterativeDeepeningSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Graph<T> graph, T startValue, T finishValue) {
        Node<T> start = graph.getNode(startValue).get();
        Node<T> finish = graph.getNode(finishValue).get();
        for (int depth = 1; depth < Integer.MAX_VALUE; depth++) {
            Optional<Node<T>> result = DepthLimitedSearchAlgorithm.search(graph, startValue, finishValue, depth);
            if(result.isPresent()) {
                DepthLimitedSearchAlgorithm.trace(start);
                System.out.println("Глубина: " + depth);
                return result;
            }
        }
        return Optional.empty();
    }
}