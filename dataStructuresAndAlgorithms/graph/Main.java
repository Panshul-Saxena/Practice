package dataStructuresAndAlgorithms.graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.printGraph();
//        graph.addEdge("A", "B");
//        graph.addEdge("B", "C");
//        graph.addEdge("C", "D");
//        graph.addEdge("D", "A");
//        graph.addEdge("A", "C");
//        graph.addEdge("B", "D");
//        graph.printGraph();
//        graph.removeEdge("A", "C");
//        graph.printGraph();
//        graph.removeVertex("D");
//        graph.printGraph();

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");
        graph.addVertex("8");
        graph.addVertex("9");
        graph.addVertex("10");

        graph.addEdge("1", "2");
        graph.addEdge("1", "4");
        graph.addEdge("2", "3");
        graph.addEdge("2", "5");
        graph.addEdge("2", "7");
        graph.addEdge("2", "8");
        graph.addEdge("3", "4");
        graph.addEdge("3", "9");
        graph.addEdge("3", "10");
        graph.addEdge("5", "6");
        graph.addEdge("5", "7");
        graph.addEdge("7", "8");
        System.out.println(graph.BFS("1"));
        System.out.println(graph.DFS("1"));

    }
}
