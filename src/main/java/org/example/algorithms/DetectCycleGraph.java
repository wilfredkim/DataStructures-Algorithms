package org.example.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleGraph {
    /*-Create the graph using the given number of edges and vertices.
    -Create a recursive function that initializes the current vertex, visited array, and recursion stack.
    -Mark the current node as visited and also mark the index in the recursion stack.
    -Find all the vertices which are not visited and are adjacent to the current node and recursively call the function for those vertices
    -If the recursive function returns true, return true.
    -If the adjacent vertices are already marked in the recursion stack then return true.
    -Create a wrapper function, that calls the recursive function for all the vertices, and
    -If any function returns true return true.
    -Else if for all vertices the function returns false return false.*/

    private final int V;
    private final List<List<Integer>> adj;

    public DetectCycleGraph(int V) {
        this.V = V;
        this.adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
    }

    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        // Mark the current node as visited and
        // part of recursion stack
        if (recStack[i])
            return true;
        if (visited[i])
            return false;
        visited[i] = true;
        recStack[i] = true;

        List<Integer> children = adj.get(i);
        for (Integer c : children) {
            if (isCyclicUtil(c, visited, recStack))
                return true;
        }
        recStack[i] = false;
        return false;
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleGraph graph = new DetectCycleGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
