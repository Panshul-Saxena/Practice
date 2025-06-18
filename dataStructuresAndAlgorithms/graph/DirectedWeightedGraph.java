package dataStructuresAndAlgorithms.graph;

import java.util.HashMap;
import java.util.ArrayList;

public class DirectedWeightedGraph {
    private HashMap<String, ArrayList<Edge>> adjList = new HashMap<>();

    private static class Edge {
        String destination;
        int weight;

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(String destination, int weight) {
        if (adjList.containsKey(destination)) {
            adjList.get(destination).add(new Edge(destination, weight));
        }
    }

    public void removeVertex(String vertex) {
        if (adjList.containsKey(vertex)) {
            adjList.get(vertex).clear();
            
        }
    }




}
