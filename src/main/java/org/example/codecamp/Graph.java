package org.example.codecamp;

import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    //graph = nodes+edges
    //directed and undirected graph
    //undirected graph  - two way street
    //neighbor node- accessible through an edge.
    // -graph representation ->--- adjacency list and adjacency matrix
    //adjacency list is the preferred way.

    //traversal
    //DFS-> uses a Stack
    //BFS  -.Uses a queue.


    // creating graph using adjacency list;
/*    a---------->c
      |

 */
    public static void main(String[] args) {
//creating nodes
        int nodes = 5; //6 vertices/nodes.
        ArrayList<ArrayList<Integer>> nodesList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            nodesList.add(new ArrayList<Integer>());
        }
        // Adding edges one by one
        addEdge(nodesList, 0, 1);
        addEdge(nodesList, 0, 4);
        addEdge(nodesList, 1, 2);
        addEdge(nodesList, 1, 3);
        addEdge(nodesList, 1, 4);
        addEdge(nodesList, 2, 3);
        addEdge(nodesList, 3, 4);
         printGraph(nodesList);


    }

    static void addEdge(ArrayList<ArrayList<Integer>> arrayList, int nodea, int nodeb) {
        arrayList.get(nodea).add(nodeb);
        arrayList.get(nodeb).add(nodea);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Adjacent List of Vertex " + i);
            for (int j = 0; j < arrayList.get(i).size(); j++) {
                System.out.print(" ->" + arrayList.get(i).get(j));
            }
            System.out.println();
        }

    }

    static void dFs(ArrayList<ArrayList<Integer>> graph, Stack<Integer> source) {
        Stack<Integer> stack =source;
        while (stack.size() > 0) {
           int  current = stack.pop();
            System.out.println(current);
           /* for (ArrayList<Integer> arrayList: graph.get(current)) {
                stack.push(arrayList);
            }*/
        }
    }
}
