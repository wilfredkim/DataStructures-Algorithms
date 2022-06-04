package org.example;

import java.util.LinkedList;

public class LinkedListDataStructure {

    public  static  void  main (String ...args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(52);
        linkedList.add(12);
        linkedList.add(16);
        linkedList.add(48);
        int first =linkedList.pollFirst();
        int last =linkedList.pollLast();
        System.out.println(first);
        System.out.println(last);
        System.out.println(linkedList);
    }
}
