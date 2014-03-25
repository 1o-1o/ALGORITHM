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
        Node T = tree.HEAD;
        Node S = tree.HEAD.RLINK;
        Node P = tree.HEAD.RLINK;
        int a;
        if(P == null){
            tree.insertNode(P, key);
            System.out.println(String.format("%2s", i++)+":"+String.format("%4s", key)+": not found in the current balanced tree, and then insert it in the tree.");
        }else {
            do{
                if(key < P.KEY){
                    Node Q = P.LLINK;
                    if(Q == null){
                        tree.insertNode(P, key);
                        System.out.println(String.format("%2s", i++)+":"+String.format("%4s", key)+": not found in the current balanced tree, and then insert it in the tree.");
                        Node R = null;
                        if(key < S.KEY){                    /*A6*/
                            a = -1;
                        }else {
                            a = 1;
                        }
                        if(a == -1){
                            R = P = S.LLINK;
                        }else if(a == 1){
                            R = P = S.RLINK;
                        }
                        do{
                            if(key < P.KEY){
                                P.B = -1;
                                P = P.LLINK;
                            }else if(key > P.KEY){
                                P.B = 1;
                                P = P.RLINK;
                            }else {
                                break;
                            }
                        }while (true);
                        if(S.B == 0){                            /*A7 i)*/
                            S.B = a;
                            tree.HEAD.KEY++;
                            break;
                        }else if(S.B == -a){                     /*A7 ii)*/
                            S.B = 0;
                            break;
                        }else if(S.B == a){                      /*A7 iii)*/
                            if(R.B == a){
                                P = R;                           /*A8*/
                                if(a == -1){
                                    S.LLINK = R.RLINK;
                                    R.RLINK = S;
                                }else if(a == 1){
                                    S.RLINK = R.LLINK;
                                    R.LLINK = S;
                                }
                                S.B = R.B = 0;
                            }else if(R.B == -a){
                                if(a == -1){                  /*A9*/
                                    P = R.RLINK;
                                    R.RLINK = P.LLINK;
                                    P.LLINK = R;
                                    S.LLINK = P.RLINK;
                                    P.RLINK = S;
                                }else if(a == 1){
                                    P = R.LLINK;
                                    R.LLINK = P.RLINK;
                                    P.RLINK = R;
                                    S.RLINK = P.LLINK;
                                    P.LLINK = S;
                                }
                                if(P.B == a){
                                    S.B = -a;
                                    R.B = 0;
                                }else if(P.B == 0){
                                    S.B = 0;
                                    R.B = 0;
                                }else if(P.B == -a){
                                    S.B = 0;
                                    R.B = a;
                                }
                                P.B = 0;
                            }
                            if(S == T.RLINK){              /*A10*/
                                T.RLINK = P;
                            }else {
                                T.LLINK = P;
                            }
                        }
                        break;
                    }else {
                        if(Q.B != 0){
                            T = P;
                            S = Q;
                        }
                        P = Q;
                    }
                }else if(key > P.KEY){
                    Node Q = P.RLINK;
                    if(Q == null){
                        tree.insertNode(P, key);
                        System.out.println(String.format("%2s", i++)+":"+String.format("%4s", key)+": not found in the current balanced tree, and then insert it in the tree.");
                        Node R = null;
                        if(key < S.KEY){                    /*A6*/
                            a = -1;
                        }else {
                            a = 1;
                        }
                        if(a == -1){
                            R = P = S.LLINK;
                        }else if(a == 1){
                            R = P = S.RLINK;
                        }
                        do{
                            if(key < P.KEY){
                                P.B = -1;
                                P = P.LLINK;
                            }else if(key > P.KEY){
                                P.B = 1;
                                P = P.RLINK;
                            }else {
                                break;
                            }
                        }while (true);
                        if(S.B == 0){                            /*A7 i)*/
                            S.B = a;
                            tree.HEAD.KEY++;
                            break;
                        }else if(S.B == -a){                     /*A7 ii)*/
                            S.B = 0;
                            break;
                        }else if(S.B == a){                      /*A7 iii)*/
                            if(R.B == a){
                                P = R;                           /*A8*/
                                if(a == -1){
                                    S.LLINK = R.RLINK;
                                    R.RLINK = S;
                                }else if(a == 1){
                                    S.RLINK = R.LLINK;
                                    R.LLINK = S;
                                }
                                S.B = R.B = 0;
                            }else if(R.B == -a){
                                if(a == -1){                  /*A9*/
                                    P = R.RLINK;
                                    R.RLINK = P.LLINK;
                                    P.LLINK = R;
                                    S.LLINK = P.RLINK;
                                    P.RLINK = S;
                                }else if(a == 1){
                                    P = R.LLINK;
                                    R.LLINK = P.RLINK;
                                    P.RLINK = R;
                                    S.RLINK = P.LLINK;
                                    P.LLINK = S;
                                }
                                if(P.B == a){
                                    S.B = -a;
                                    R.B = 0;
                                }else if(P.B == 0){
                                    S.B = 0;
                                    R.B = 0;
                                }else if(P.B == -a){
                                    S.B = 0;
                                    R.B = a;
                                }
                                P.B = 0;
                            }
                            if(S == T.RLINK){              /*A10*/
                                T.RLINK = P;
                            }else {
                                T.LLINK = P;
                            }
                        }
                        break;
                    }else {
                        if(Q.B != 0){
                            T = P;
                            S = Q;
                        }
                        P = Q;
                    }
                }else {
                    System.out.println(key+" found in the balanced binary tree.");
                    break;
                }
            }while (true);
        }
    }

    public static void main(String[] args) {

        /*Prepare the binary tree*/
        System.out.println("Prepare the balanced binary tree:");
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

        /*Inorder print the current balanced binary tree with 16 nodes*/
        System.out.println("Inorder print the current balanced binary tree with 16 nodes:");
        tree.inorderTreePrint(tree.ROOT);
        System.out.println();

        /*Search Node 765 in current balanced binary tree*/
        System.out.println("Search Node 765 in current balanced binary tree:");
        searchAndInsertNode(765);
    }
}