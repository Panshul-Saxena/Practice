package dataStructuresAndAlgorithms.graph;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (!adjList.containsKey(vertex)) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) return false;
        for (String otherVertex: adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
        return true;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.containsKey(vertex1) && adjList.containsKey(vertex2)) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public ArrayList<String> BFS(String vertex) {
        ArrayList<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(vertex);
        visited.add(vertex);

        while (!queue.isEmpty()) {
            String currentVertex = queue.remove();
            for (String neighbor : adjList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited;
    }

    private void DFS(String vertex, ArrayList<String> visited) {
        visited.add(vertex);

        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                DFS(neighbor, visited);
            }
        }
    }

    public ArrayList<String> DFS(String vertex) {
        ArrayList<String> visited = new ArrayList<>();
        DFS(vertex, visited);
        return visited;
    }
}
