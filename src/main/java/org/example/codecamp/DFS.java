package org.example.codecamp;

import java.util.Stack;

public class DFS {
    private int V;
    private Stack<String> adj[];

    // Constructor
    DFS(int nodes) {
        V = nodes;
        adj = new Stack[nodes];
        for (int i = 0; i < nodes; ++i)
            adj[i] = new Stack();
    }

    void addEdge(int v, String w) {
        adj[v].add(w); // Add w to v's list.
    }

    void dFs(DFS graph, int source) {
        Stack<String> stack =adj[source];
        while(stack.size()>0){
            String current =stack.pop();
            System.out.println(current);
            //for(String s: graph.adj[])
        }


    }


    public static void main(String... args) {
        DFS graph = new DFS(6);
        graph.addEdge(0, "b");
        graph.addEdge(0, "c");
        graph.addEdge(1, "d");
        graph.addEdge(2, "e");
        graph.addEdge(3, "f");
        graph.addEdge(4, "");
        graph.addEdge(5, "");


    }

}
