public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[33];
        int temp;

        /*Prepare the data*/
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
        int s = 0;
        int i = -1;
        int j = -1;
        int k = -1;
        int l = -1;
        int d;
        int f;

        do{                            /*N2*/
            if(s == 0){
                i = 1;
                j = N;
                k = N+1;
                l = 2*N;
            }else if(s == 1){
                i = N+1;
                j = 2*N;
                k = 1;
                l = N;
            }
            d = 1;
            f = 1;
            do{                       /*N3*/
                if(K[i] > K[j]){
                    K[k] = K[j];      /*N8*/
                    k += d;
                    j--;
                    if(K[j+1] <= K[j]){  /*N9*/
                        continue;
                    }else {
                        do{
                            K[k] = K[i];  /*N10*/
                            k += d;
                            i++;
                        }while (K[i-1] <= K[i]);
                        f = 0;
                        d = -d;
                        temp = k;
                        k = l;
                        l = temp;
                    }
                }else if(i != j && K[i] <= K[j]){
                    K[k] = K[i];                 /*N4*/
                    k += d;
                    i++;                             /*N5*/
                    if(K[i-1] <= K[i]){
                        continue;
                    }else {
                        do{
                            K[k] = K[j];    /*N6*/
                            k += d;
                            j--;
                        }while (K[j+1] <= K[j]);
                        f = 0;
                        d = 0-d;
                        temp = k;
                        k = l;
                        l = temp;
                    }
                }else if(i == j){
                    K[k] = K[i];
                    if(f == 0){
                        s = 1 - s;
                    }
                    break;
                }
            }while (true);
        }while (f == 0);

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(int m=1; m<=N; m++){
            System.out.println(m+":"+K[m]);
        }
    }
}
