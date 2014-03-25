package com.algorithms.searching;

/**
 * Created with IntelliJ IDEA.
 * User: 1O1O
 * Date: 12/12/13
 * Time: 6:52 PM
 * :)~
 * Radix List Sort:Sorting by Distribution:Internal Sorting
 */
public class Main {

    public static Tree tree = new Tree();
    public static int i =1;

    public static void searchAndInsertNode(int key){
        Node P = tree.ROOT;
        if(P == null){
            tree.insertNode(P, key);
            System.out.println(String.format("%2s", i++)+":"+String.format("%4s", key)+": not found in the current tree, and then insert it in the tree.");
        }else {
            do{
                if(key < P.KEY){
                    if(P.LLINK != null){
                        P = P.LLINK;
                    }else {
                        tree.insertNode(P, key);
                        System.out.println(String.format("%2s", i++)+":"+String.format("%4s", key)+": not found in the current tree, and then insert it in the tree.");
                        break;
                    }
                }else if(key > P.KEY){
                    if(P.RLINK != null){
                        P = P.RLINK;
                    }else {
                        tree.insertNode(P, key);
                        System.out.println(String.format("%2s", i++)+":"+String.format("%4s", key)+": not found in the current tree, and then insert it in the tree.");
                        break;
                    }
                }else {
                    System.out.println(key+" found in the binary tree.");
                    break;
                }
            }while (true);
        }
    }

    public static void main(String[] args) {

        /*Prepare the binary tree*/
        System.out.println("Prepare the binary tree:");
        searchAndInsertNode(503);
        searchAndInsertNode(87);
        searchAndInsertNode(512);
        searchAndInsertNode(61);
        searchAndInsertNode(908);
        searchAndInsertNode(170);
        searchAndInsertNode(897);
        searchAndInsertNode(275);
        searchAndInsertNode(653);
        searchAndInsertNode(426);
        searchAndInsertNode(154);
        searchAndInsertNode(509);
        searchAndInsertNode(612);
        searchAndInsertNode(677);
        searchAndInsertNode(765);
        searchAndInsertNode(703);
        System.out.println();

        /*Inorder print the current binary tree with 16 nodes*/
        System.out.println("Inorder print the current binary tree with 16 nodes:");
        tree.inorderTreePrint(tree.ROOT);
        System.out.println();

        /*Search Node 765 in current binary tree*/
        System.out.println("Search Node 765 in current binary tree:");
        searchAndInsertNode(765);
    }
}