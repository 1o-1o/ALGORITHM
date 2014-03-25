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

    public static int[] TABLE = new int[19];
    public static int M = 19;
    public static int N = 0;

    public static void searchAndInsertNode(int key){
        int hash = key%19;                           /*Hash function:h(K)*/

        if(TABLE[hash] == 0){
            TABLE[hash] = key;
            N++;
            System.out.println(String.format("%4s",key+":")+" not found in the hash table, then insert it in TABLE["+hash+"]");
        }else {
            if(key == TABLE[hash]){
                System.out.println(key+" found in the hash table: TABLE["+hash+"]");
            }else {
                do{
                    hash--;
                    if(hash < 0){
                        hash+=M;
                    }
                    if(TABLE[hash] == 0){
                        if(N == M-1){
                            System.out.println("Error: Hash Table Overflow!"+", Key:"+key+" can not be inserted!");
                            break;
                        }else {
                            TABLE[hash] = key;
                            N++;
                            System.out.println(String.format("%4s",key+":")+" not found in the hash table, then insert it in TABLE["+hash+"]");
                            break;
                        }
                    }
                }while (true);
            }
        }
    }

    public static void main(String[] args) {

        /*Prepare the Hash Table: suppose all the numbers are not zero!!!*/
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
        for(int j=0; j<19; j++){
            if(TABLE[j] != 0){
                System.out.println(String.format("%3s", j+":")+TABLE[j]);
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