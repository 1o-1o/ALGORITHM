package com.algorithms.searching;

/**
 * Created with IntelliJ IDEA.
 * User: 1O1O
 * Date: 12/12/13
 * Time: 5:22 PM
 * :)~
 * Radix List Sort:Sorting by Distribution:Internal Sorting
 */

public class Tree {
    public Node HEAD = new Node(0);
    public Node ROOT = null;
    private int index = 1;

    public void insertNode(Node P, int key){
        Node node = new Node(key);
        node.LLINK = null;
        node.RLINK = null;
        if(ROOT == null){
            ROOT = node;
            HEAD.RLINK = ROOT;
        }else if(key < P.KEY){
            P.LLINK = node;
        }else if(key > P.KEY){
            P.RLINK = node;
        }
    }

    public void inorderTreePrint(Node root){
        if(root != null){
            inorderTreePrint(root.LLINK);
            System.out.println((index++)+":"+root.KEY);
            inorderTreePrint(root.RLINK);
        }
    }
}