public class Main {

    public static int PARTITION(int[] K, int p, int r){
        int x = K[r];
        int i = p-1;
        int temp;
        for(int j=p; j<=r-1; j++){
            if(K[j] <= x){
                i++;
                temp = K[i];
                K[i] = K[j];
                K[j] = temp;
            }
        }
        temp = K[i+1];
        K[i+1] = K[r];
        K[r] = temp;
        return i+1;
    }

    public static void QUICKSORT(int[] K, int p, int r){
        if(p < r){
            int q = PARTITION(K, p, r);
            QUICKSORT(K, p, q-1);
            QUICKSORT(K, q+1, r);
        }
    }

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];

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
        QUICKSORT(K, 1, N);

        //Output sorted Ks
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
