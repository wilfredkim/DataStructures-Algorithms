package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    //the method adds a new vertex to the graph
    public void addNewVertex(T s) {
        map.put(s, new LinkedList<T>());
    }


    //the method adds an edge between source and destination
    public void addNewEdge(T source, T destination, boolean bidirectional) {
//
        if (!map.containsKey(source))
            addNewVertex(source);
        if (!map.containsKey(destination))
            addNewVertex(destination);
        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    //the method counts the number of vertices
    public void countVertices() {
        System.out.println("Total number of vertices: " + map.keySet().size());
    }

    //the method counts the number of edges
    public void countEdges(boolean bidirection) {
//variable to store number of edges
        int count = 0;
        for (T v : map.keySet()) {
            count = count + map.get(v).size();
        }
        if (bidirection) {
            count = count / 2;
        }
        System.out.println("Total number of edges: " + count);
    }

    //checks a graph has vertex or not
    public void containsVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//foreach loop that iterates over the keys
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
//foreach loop for getting the vertices
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}

