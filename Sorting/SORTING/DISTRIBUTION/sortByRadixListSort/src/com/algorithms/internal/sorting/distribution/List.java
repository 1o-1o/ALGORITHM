package com.algorithms.internal.sorting.distribution;

/**
 * Created with IntelliJ IDEA.
 * User: zfan
 * Date: 12/5/13
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class List {
    public Node Head = null;
    private Node Pointer = null;
    private int Length = 0;

    public void insert(int d){
        Node e=new Node(d);
        e.next = Head;
        Head = e;
        Length++;
    }

    public Node current(){
        if(Head == null)
            return null;
        else
            return Head;
    }

    public void printList(){
        Pointer = Head;
        int i = 1;
        while (Pointer != null){
            System.out.println(i+":"+Pointer.data);
            Pointer = Pointer.next;
            i++;
        }
    }
}
