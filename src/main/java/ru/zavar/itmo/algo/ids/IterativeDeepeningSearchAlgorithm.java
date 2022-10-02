package ru.zavar.itmo.algo.ids;

import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.Node;
import ru.zavar.itmo.algo.dls.DepthLimitedSearchAlgorithm;

import java.util.Optional;

public final class IterativeDeepeningSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Graph<T> graph, T startValue, T finishValue) {
        System.out.println("Поиск с итеративным углублением:");
        Node<T> start = graph.getNode(startValue).get();
        Node<T> finish = graph.getNode(finishValue).get();
        for (int depth = 1; depth < Integer.MAX_VALUE; depth++) {
            Optional<Node<T>> result = DepthLimitedSearchAlgorithm.search(graph, startValue, finishValue, depth);
            if(result.isPresent()) {
                System.out.println("Глубина: " + depth + "\n");
                return result;
            }
        }
        return Optional.empty();
    }
}
