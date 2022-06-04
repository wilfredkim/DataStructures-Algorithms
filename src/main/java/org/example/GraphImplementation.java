package org.example;

public class GraphImplementation {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNewVertex("a");
        graph.addNewVertex("b");
        graph.addNewVertex("c");
        graph.addNewVertex("e");
        graph.addNewVertex("f");
        graph.addNewEdge("a", "b", false);
        graph.addNewEdge("a", "c", false);
        graph.addNewEdge("b", "d", false);
        graph.addNewEdge("f", "d", false);
        graph.addNewEdge("c", "e", false);
        graph.addNewEdge("e", "b", false);
        System.out.println("Adjacency List for the graph:\n" + graph.toString());

    }



}
