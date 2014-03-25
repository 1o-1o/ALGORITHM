package com.algorithms.internal.sorting.distribution;

public class Main {

    public static void main(String[] args) {
        List K = new List();
        Node[] TOP = new Node[10];
        Node[] BOTM = new Node[10];
        int p = 3;                 /*Decimal bits of each of the Ks to be sorted*/
        int M = 10;                /*Decimal*/

        /*Prepare the data*/
        K.insert(703);
        K.insert(765);
        K.insert(677);
        K.insert(612);
        K.insert(509);
        K.insert(154);
        K.insert(426);
        K.insert(653);
        K.insert(275);
        K.insert(897);
        K.insert(170);
        K.insert(908);
        K.insert(61);
        K.insert(512);
        K.insert(87);
        K.insert(503);

        /*Output unsorted Ks*/
        System.out.println("Unsorted Ks:");
        K.printList();
        System.out.println();

        /*Kernel of the Algorithm!*/
        Node P = null;
        P = K.current();                        /*R1*/
        Node Point = null;

        int Key;

        for(int k=1; k<=p; k++){
            for(int i=0; i<M; i++){
                TOP[i] = BOTM[i] = null;            /*R2*/
            }
            do{
                Key = P.data;                       /*R3*/
                int i = p+1-k;
                switch (i){
                    case 1: i = Key/100; break;
                    case 2: i = (Key/10)%10; break;
                    case 3: i = Key%10; break;
                }

                Point = P;
                if(k == 1){                             /*R4 R5*/
                    if(P.next != null){
                        P = P.next;
                        Point.next = BOTM[i];
                        if(BOTM[i] == null){
                            TOP[i] = BOTM[i] = Point;
                        }else {
                            BOTM[i] = Point;
                        }
                        continue;
                    } else {
                        Point.next = BOTM[i];
                        if(BOTM[i] == null){
                            TOP[i] = BOTM[i] = Point;
                        }else {
                            BOTM[i] = Point;
                        }
                    }
                }else {
                    if(P.next != null){          /*R5*/
                        P = P.next;
                        Point.next = null;
                        if(TOP[i] == null){
                            TOP[i] = BOTM[i] = Point;
                        }else {
                            TOP[i].next = Point;
                            TOP[i] = Point;
                        }
                        continue;
                    } else {
                        Point.next = null;
                        if(TOP[i] == null){
                            TOP[i] = BOTM[i] = Point;
                        }else {
                            TOP[i].next = Point;
                            TOP[i] = Point;
                        }
                    }
                }
                                                         /*R6*/
                int j = 0;                      /*H1*/
                do{
                    P = TOP[j];                     /*H2*/
                    do{
                        j++;                        /*H3*/
                        if(j == M){
                            P.next = null;
                            break;
                        }
                        if(BOTM[j] == null){        /*H4*/

                        }else {
                            P.next = BOTM[j];       /*H5*/
                            break;
                        }
                    }while (true);
                    if(j == M){
                        K.Head = BOTM[0];
                        break;
                    }
                }while (true);
                P = BOTM[0];
                break;
            }while (true);
        }

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        K.printList();
        System.out.println();
    }
}


