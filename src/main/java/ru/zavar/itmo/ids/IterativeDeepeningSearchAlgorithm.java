package ru.zavar.itmo.ids;

import ru.zavar.itmo.Node;
import ru.zavar.itmo.dls.DepthLimitedSearchAlgorithm;

import java.util.Optional;

public final class IterativeDeepeningSearchAlgorithm {
    public static <T> Optional<Node<T>> search(Node<T> start, Node<T> target) {
        for (int depth = 1; depth < Integer.MAX_VALUE; depth++) {
            Optional<Node<T>> result = DepthLimitedSearchAlgorithm.search(start, target, depth);
            if(result.isPresent()) {
                DepthLimitedSearchAlgorithm.trace(start);
                System.out.println("Глубина: " + depth);
                return result;
            }
        }
        return Optional.empty();
    }
}
