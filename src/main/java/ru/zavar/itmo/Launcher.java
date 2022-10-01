package ru.zavar.itmo;

import ru.zavar.itmo.algo.bfs.BreadthFirstSearchAlgorithm;
import ru.zavar.itmo.algo.bis.BidirectionalSearchAlgorithm;
import ru.zavar.itmo.algo.dfs.DepthFirstSearchAlgorithm;
import ru.zavar.itmo.algo.dls.DepthLimitedSearchAlgorithm;
import ru.zavar.itmo.graph.Graph;
import ru.zavar.itmo.graph.GraphBuilder;
import ru.zavar.itmo.algo.ids.IterativeDeepeningSearchAlgorithm;

public final class Launcher {
    public static void main(String[] args) {
        GraphBuilder<String> graphBuilder = new GraphBuilder<>();
        Graph<String> graph = graphBuilder
                .addNode("Одесса", 0)
                .addNode("Киев", 441)
                .addNode("Симферополь", 313)
                .addNode("Харьков", 565)
                .addNode("Донецк", 561)
                .addNode("Кишинёв", 157)
                .addNode("Житомир", 446)
                .addNode("Волгоград", 1064)
                .addNode("Воронеж", 844)
                .addNode("Витебск", 969)
                .addNode("Брест", 807)
                .addNode("Калининград", 1164)
                .addNode("Вильнюс", 991)
                .addNode("Даугавпилс", 1085)
                .addNode("Каунас", 1052)
                .addNode("Таллин", 1495)
                .addNode("Рига", 1249)
                .addNode("С. Петербург", 1498)
                .addNode("Ярославль", 1387)
                .addNode("Орёл", 817)
                .addNode("Ниж. Новгород", 1428)
                .addNode("Москва", 1137)
                .addNode("Казань", 1643)
                .addNode("Минск", 855)
                .addNode("Уфа", 1993)
                .addNode("Мурманск", 2508)
                .addNode("Самара", 1574)

                .addEdge("Одесса", "Киев", 487)
                .addEdge("Симферополь", "Харьков", 639)
                .addEdge("Харьков", "Киев", 471)
                .addEdge("Киев", "Кишинёв", 467)
                .addEdge("Киев", "Вильнюс", 734)
                .addEdge("Киев", "Житомир", 131)
                .addEdge("Кишинёв", "Донецк", 812)
                .addEdge("Донецк", "Житомир", 863)
                .addEdge("Житомир", "Волгоград", 1493)
                .addEdge("Донецк", "Орёл", 709)
                .addEdge("Донецк", "Москва", 1084)
                .addEdge("Самара", "Уфа", 461)
                .addEdge("Уфа", "Казань", 525)
                .addEdge("Казань", "Москва", 815)
                .addEdge("Москва", "Минск", 690)
                .addEdge("Минск", "Мурманск", 2238)
                .addEdge("Москва", "С. Петербург", 664)
                .addEdge("Мурманск", "С. Петербург", 1412)
                .addEdge("Минск", "Ярославль", 940)
                .addEdge("Москва", "Ниж. Новгород", 411)
                .addEdge("Москва", "Орёл", 368)
                .addEdge("Воронеж", "Ярославль", 739)
                .addEdge("Воронеж", "Витебск", 869)
                .addEdge("Волгоград", "Витебск", 1455)
                .addEdge("Воронеж", "Волгоград", 581)
                .addEdge("Рига", "С. Петербург", 641)
                .addEdge("Витебск", "С. Петербург", 602)
                .addEdge("Калининград", "С. Петербург", 739)
                .addEdge("Витебск", "Орёл", 522)
                .addEdge("Витебск", "Ниж. Новгород", 911)
                .addEdge("Витебск", "Вильнюс", 360)
                .addEdge("Витебск", "Брест", 638)
                .addEdge("Брест", "Вильнюс", 531)
                .addEdge("Калининград", "Вильнюс", 333)
                .addEdge("Каунас", "Вильнюс", 102)
                .addEdge("Даугавпилс", "Вильнюс", 211)
                .addEdge("Брест", "Калининград", 699)
                .addEdge("Каунас", "Рига", 267)
                .addEdge("Таллин", "Рига", 308)

                .build();

        BreadthFirstSearchAlgorithm.search(graph,"Рига", "Одесса");
        DepthFirstSearchAlgorithm.trace(DepthFirstSearchAlgorithm.search(graph,"Рига", "Одесса").get());
        DepthLimitedSearchAlgorithm.trace(DepthLimitedSearchAlgorithm.search(graph,"Рига", "Одесса", 4).get());
        IterativeDeepeningSearchAlgorithm.search(graph, "Рига", "Одесса");
        BidirectionalSearchAlgorithm.search(graph, "Рига", "Одесса");
    }
}
