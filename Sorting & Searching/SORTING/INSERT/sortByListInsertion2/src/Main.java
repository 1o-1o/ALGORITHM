public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        int[] L = new int[17];
        L[0] = N;
        L[N] = 0;

        //Prepare the data
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

        //Output unsorted Ks
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        //Kernel of the Algorithm!
        for(int j=N-1; j>=1; j--){
            int p = L[0];
            int q = 0;
            int Key = K[j];
            while (p > 0){
                if(Key <= K[p]){
                    break;
                }else {
                    q = p;
                    p = L[q];
                }
            }
            L[q] = j;
            L[j] = p;
        }

        //Output sorted Ks
        System.out.println("Sorted Ks:");
        int index = 0;
        int pos = 0;
        while (L[index] != 0){
            pos++;
            System.out.println(pos+":"+K[L[index]]);
            index = L[index];
        }
    }
}