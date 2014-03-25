public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        int[] L = new int[18];

        /*Prepare the input data*/
        K[1] = 503;
        K[2] = 87;
        K[3] = 512;
        K[4] = 61;
        K[5] = 908;
        K[6] = 170;
        K[7] = 897;
        K[8] = 275;
        K[9] = 653;
        K[10] = 426;
        K[11] = 154;
        K[12] = 509;
        K[13] = 612;
        K[14] = 677;
        K[15] = 765;
        K[16] = 703;

        /*Output unsorted Ks*/
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        /*Kernel of the Algorithm!*/
        int s;
        int t;
        int p;
        int q;

        L[0] = 1;                               /*L1*/
        L[N+1] = 2;
        for(int i=1; i<=N-2; i++){
            L[i] = -(i+2);
        }
        L[N-1] = L[N] = 0;

        do{
            s = 0;                             /*L2*/
            t = N+1;
            p = L[s];
            q = L[t];

            if(q == 0){
                break;
            }
            do{
                if(K[p] > K[q]){                 /*L3*/
                    if(L[s] >= 0){               /*L6*/
                        L[s] = Math.abs(q);
                    }else {
                        L[s] = -Math.abs(q);
                    }
                    s = q;
                    q = L[q];

                    if(q > 0){
                        continue;
                    }
                    L[s] = p;                    /*L7*/
                    s = t;
                    do{
                        t = p;
                        p = L[p];
                    }while (p > 0);
                } else {
                    if(L[s] >= 0){              /*L4*/
                        L[s] = Math.abs(p);
                    }else {
                        L[s] = -Math.abs(p);
                    }
                    s = p;
                    p = L[p];
                    if(p > 0){
                        continue;
                    }
                    L[s] = q;                   /*L5*/
                    s = t;
                    do{
                        t = q;
                        q = L[q];
                    }while (q > 0);
                }

                p = -p;                          /*L8*/
                q = -q;
                if(q == 0){
                    if(L[s] >= 0){
                        L[s] = Math.abs(p);
                    }else {
                        L[s] = -Math.abs(p);
                    }
                    L[t] = 0;
                    break;
                }
            }while (true);
        }while (true);

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        int index = 0;
        int i = 1;
        while (L[index] > 0){
            System.out.println(i+":"+K[L[index]]);
            index = L[index];
            i++;
        }
    }
}
