public class Main {

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
        int dest = 0;
        for(int j=2; j<=N; j++){
            int Key = K[j];
            int i = 1;
            int k = j-1;
            while (i <= k){
                int mid = (i+k)/2;
                if(K[mid] < Key){
                    i = ++mid;
                    dest = i;
                }else if(K[mid] == Key){
                    dest = ++mid;
                    break;
                }else{
                    dest = mid;
                    k = --mid;
                }
            }
            for(int n=j; n>dest; n--){
                K[n] = K[n-1];
            }
            K[dest] = Key;
        }

        //Output sorted Ks
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
