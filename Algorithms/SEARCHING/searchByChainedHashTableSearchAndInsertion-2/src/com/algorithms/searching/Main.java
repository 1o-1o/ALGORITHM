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

    public static Node[] HEAD = new Node[20];
    public static int M = 19;
    public static int R = M+1;

    public static void searchAndInsertNode(int key){
        int hash = key%19+1;                       /*Hash function:h(K)*/
        Node pointer;

        if(HEAD[hash] == null){
            Node node = new Node(key);
            HEAD[hash] = node;
            System.out.println(String.format("%4s",key+":")+" not found in the hash table, then insert it in HEAD["+hash+"] list");
        }else {
            pointer = HEAD[hash];
            do{
                if(key == pointer.KEY){
                    System.out.println(key+" found in the hash table: HEAD["+hash+"]");
                    break;
                }
                if(pointer.LINK != null){
                    pointer = pointer.LINK;
                }else {
                    Node node = new Node(key);
                    pointer.LINK = node;
                    System.out.println(String.format("%4s",key+":")+" not found in the hash table, then insert it in HEAD["+hash+"] list");
                    break;
                }
            }while (true);
        }
    }

    public static void main(String[] args) {

        /*Prepare the Hash Table*/
        System.out.println("Prepare the Hash Table:");
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

        /*Print the current Hash Table with 16 nodes*/
        System.out.println("Print the current Hash Table with 16 nodes:");
        for(int j=1; j<=19; j++){
            Node point = HEAD[j];
            if(point != null){
                System.out.print(String.format("%3s", j+":")+String.format("%4s", point.KEY));
                point = point.LINK;
                while (point != null){
                    System.out.print(" ->"+String.format("%4s", point.KEY));
                    point = point.LINK;
                }
                System.out.println();
            }
        }
        System.out.println();

        /*Search Node 765 in current Hash Table*/
        System.out.println("Search Node 765 in current Hash Table:");
        searchAndInsertNode(765);
        System.out.println();

        searchAndInsertNode(1);
        searchAndInsertNode(2);
        searchAndInsertNode(3);
        searchAndInsertNode(4);
        searchAndInsertNode(5);
    }
}