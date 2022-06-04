package org.example;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphII {
    //stores the number of vertices
    private int vertices;
    //creates a linked list for the adjacency list of the graph
    private LinkedList<Integer> adjlist[];

    //creating a constructor of the Graph class
    GraphII(int count_v) {
//assigning the number of vertices to the passed parameter
        vertices = count_v;
        adjlist = new LinkedList[count_v];
//loop for creating the adjacency lists
        for (int i = 0; i < count_v; ++i)
            adjlist[i] = new LinkedList();
    }


    //method that adds a new edge to the graph
    void addNewEdge(int v, int w) {
        adjlist[v].add(w);  // Add w to v's list.
    }


    //logic of the DFS
//traversal starts from the root node
    void traversalDFS(int v, boolean vnodelist[]) {
//if current node (root node) is visited, add it to the vnodelist
        vnodelist[v] = true;
        System.out.print(v + " ");
//detrmines the negihboring nodes of the current node
//iterates over the list
        Iterator<Integer> i = adjlist[v].listIterator();
        while (i.hasNext()) {
//returns the next element in the iteration and store that element in the variable n
            int n = i.next();
            if (!vnodelist[n])
//calling the function that performs depth first traversal
                traversalDFS(n, vnodelist);
        }
    }


    void DFS(int v) {
//creates an array of boolean type for visited node
//initially all nodes are unvisited
        boolean visited[] = new boolean[vertices];
//call recursive traversalDFS() function for DFS
        traversalDFS(v, visited);
    }

}
