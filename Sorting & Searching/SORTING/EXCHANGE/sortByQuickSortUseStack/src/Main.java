public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[18];
        int[] L = new int[5];        /*At most Math.floor(Math.log(N)/Math.log(2))*/
        int[] R = new int[5];        /*At most Math.floor(Math.log(N)/Math.log(2))*/
        int len = 0;
        int M = 4;
        int temp;

        /*Prepare the data*/
        K[0] = -10000;              /*Negative Infinity*/
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
        K[17] = 10000;              /*Positive Infinity*/

        /*Output unsorted Ks*/
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        /*Kernel of the Algorithm!*/
        int l;
        int r;
        int i;
        int j;
        int Key;
        boolean stackEmpty = false;

        if(N > M){
            len = 0;
            l = 1;
            r = N;

            do{
                i = l;
                j = r+1;
                Key = K[l];

                do{
                    do{
                        i++;                  /*Q3*/

                    }while (K[i] < Key);

                    do{
                        j--;                    /*Q4*/
                    }while (Key < K[j]);

                    if(j <= i){                      /*Q5*/
                        temp = K[l];
                        K[l] = K[j];
                        K[j] = temp;

                        if(r-j >= j-l && j-l > M){                /*Q7*/
                            len++;
                            L[len] = j+1;
                            R[len] = r;
                            r = j-1;
                            break;
                        }else if(j-l > r-j && r-j > M){
                            len++;
                            L[len] = l;
                            R[len] = j-1;
                            l = j+1;
                            break;
                        }else if(r-j > M && M >= j-l){
                            l = j+1;
                            break;
                        }else if(j-l > M && M >= r-j){
                            r = j-1;
                            break;
                        }
                        if(len != 0){                   /*Q8*/
                            l = L[len];
                            r = R[len];
                            len--;
                        }else {
                            stackEmpty = true;
                        }
                        break;
                    }else {
                        temp = K[i];                /*Q6*/
                        K[i] = K[j];
                        K[j] = temp;
                    }
                }while (true);
            }while (!stackEmpty);

            for(j=2; j<=N; j++){               /*Q9*/
                if(K[j-1] > K[j]){
                    Key = K[j];
                    i = j-1;
                    do{
                        K[i+1] = K[i];
                        i--;
                        if(i == 0){
                            break;
                        }
                    }while (K[i] > Key);
                    K[i+1] = Key;
                }
            }
        }else {
            for(j=2; j<=N; j++){                 /*Q9*/
                if(K[j-1] > K[j]){
                    Key = K[j];
                    i = j-1;
                    do{
                        K[i+1] = K[i];
                        i--;
                        if(i == 0){
                            break;
                        }
                    }while (K[i] > Key);
                    K[i+1] = Key;
                }
            }
        }

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}