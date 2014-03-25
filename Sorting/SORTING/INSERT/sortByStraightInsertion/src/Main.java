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
        for(int j=2; j<=N; j++){
            int Key = K[j];
            int i=j-1;
            while (i > 0){
                if(Key >= K[i]){
                    K[i+1] = Key;
                    break;
                }else {
                    K[i+1] = K[i];
                    i--;
                }
            }
            if(i == 0){
                K[1] = Key;
            }
        }

        //Output sorted Ks
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        } 
    }
}
