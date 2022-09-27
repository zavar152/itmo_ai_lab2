package ru.zavar.itmo.bfs;

import ru.zavar.itmo.Graph;
import ru.zavar.itmo.GraphBuilder;
import ru.zavar.itmo.Node;

public class BfsTest {
    public static void main(String[] args) {

        GraphBuilder<String> graphBuilder = new GraphBuilder<>();
        Graph<String> graph = graphBuilder
                .addNode("Одесса")
                .addNode("Киев")
                .addNode("Симферополь")
                .addNode("Харьков")
                .addNode("Донецк")
                .addNode("Кишинёв")
                .addNode("Житомир")
                .addNode("Волгоград")
                .addNode("Воронеж")
                .addNode("Витебск")
                .addNode("Брест")
                .addNode("Калининград")
                .addNode("Вильнюс")
                .addNode("Даугавпилс")
                .addNode("Каунас")
                .addNode("Таллин")
                .addNode("Рига")
                .addNode("С. Петербург")
                .addNode("Ярославль")
                .addNode("Орёл")
                .addNode("Ниж. Новгород")
                .addNode("Москва")
                .addNode("Казань")
                .addNode("Минск")
                .addNode("Уфа")
                .addNode("Мурманск")
                .addNode("Самара")

                .addEdge("Одесса", "Киев")
                .addEdge("Симферополь", "Харьков")
                .addEdge("Харьков", "Киев")
                .addEdge("Киев", "Кишинёв")
                .addEdge("Киев", "Вильнюс")
                .addEdge("Киев", "Житомир")
                .addEdge("Кишинёв", "Донецк")
                .addEdge("Донецк", "Житомир")
                .addEdge("Житомир", "Волгоград")
                .addEdge("Донецк", "Орёл")
                .addEdge("Донецк", "Москва")
                .addEdge("Самара", "Уфа")
                .addEdge("Уфа", "Казань")
                .addEdge("Казань", "Москва")
                .addEdge("Москва", "Минск")
                .addEdge("Минск", "Мурманск")
                .addEdge("Москва", "С. Петербург")
                .addEdge("Мурманск", "С. Петербург")
                .addEdge("Минск", "Ярославль")
                .addEdge("Москва", "Ниж. Новгород")
                .addEdge("Москва", "Орёл")
                .addEdge("Воронеж", "Ярославль")
                .addEdge("Воронеж", "Витебск")
                .addEdge("Волгоград", "Витебск")
                .addEdge("Воронеж", "Волгоград")
                .addEdge("Рига", "С. Петербург")
                .addEdge("Витебск", "С. Петербург")
                .addEdge("Калининград", "С. Петербург")
                .addEdge("Витебск", "Орёл")
                .addEdge("Витебск", "Ниж. Новгород")
                .addEdge("Витебск", "Вильнюс")
                .addEdge("Витебск", "Брест")
                .addEdge("Брест", "Вильнюс")
                .addEdge("Калининград", "Вильнюс")
                .addEdge("Каунас", "Вильнюс")
                .addEdge("Даугавпилс", "Вильнюс")
                .addEdge("Брест", "Калининград")
                .addEdge("Каунас", "Рига")
                .addEdge("Таллин", "Рига")

                .build();

        graph.getNodes().forEach(stringNode1 -> {
            System.out.println(stringNode1.getValue() + ":");
            graph.getAdjNodes(stringNode1.getValue()).forEach(System.out::println);
            System.out.println();
        });

        BreadthFirstSearchAlgorithm.search(graph,"Самара", "С. Петербург");
    }
}
