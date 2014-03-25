public class Main {

    public static void ADJUST_TO_MAX_HEAP(int[] K, int j, int r, int Key){
        do{
            int i = j;
            j = 2*j;
            if(j < r){
                if(K[j] < K[j+1]){
                    j++;
                }
                if(Key >= K[j]){
                    K[i] = Key;
                    break;
                }else {
                    K[i] = K[j];
                }
            }else if(j == r){
                if(Key >= K[j]){
                    K[i] = Key;
                    break;
                }else {
                    K[i] = K[j];
                }
            }else {
                K[i] = Key;
                break;
            }
        }while (true);
    }

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        int Key = -1;

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
        int l = (int)Math.floor(N/2)+1;
        int r = N;
        while (l > 1){
            l--;
            Key = K[l];
            int j = l;
            ADJUST_TO_MAX_HEAP(K, j, r, Key);
        }
        while (r > 1){
            Key = K[r];
            K[r] = K[1];
            r--;
            int j = l;
            ADJUST_TO_MAX_HEAP(K, j, r, Key);
        }
        K[1] = Key;

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
