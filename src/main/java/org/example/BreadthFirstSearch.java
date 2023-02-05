package org.example;


import java.util.*;

public class BreadthFirstSearch {

    /*Declare a queue and insert the starting vertex.
    Initialize a visited array and mark the starting vertex as visited.
    Follow the below process till the queue becomes empty:
    Remove the first vertex of the queue.
    Mark that vertex as visited.
    Insert all the unvisited neighbors of the vertex into the queue.*/

    private int V;
    private LinkedList<Integer> adj[];

    BreadthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    void BFS(int s){
        boolean visited [] =new boolean[V];
        LinkedList<Integer>queue = new LinkedList<>();
        visited[s]= true;
        queue.add(s);
        while (queue.size()!=0){
            s = queue.poll();
            System.out.println("S:::::::::"+s);
            Iterator<Integer> i =adj[s].listIterator();
            while (i.hasNext()){
                int n  = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }


    public static void main(String... args) {
      BreadthFirstSearch bFs = new BreadthFirstSearch(6);
        bFs.addEdge(0, 1);
        bFs.addEdge(0, 2);
        bFs.addEdge(1, 2);
        bFs.addEdge(2, 0);
        bFs.addEdge(2, 3);
        bFs.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        bFs.BFS(2);
    }



}
