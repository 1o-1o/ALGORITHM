public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        int[][] D = new int[4][17];
        int digit_len = 3;
        int temp;
        int tempDigit;

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
        for(int i=1; i<=digit_len; i++){
            for(int j=1; j<=N; j++){
                switch (i){
                    case 1: D[1][j] = K[j]%10; break;
                    case 2: D[2][j] = (K[j]/10)%10; break;
                    case 3: D[3][j] = K[j]/100; break;
                }
            }
            //Stable bubble sort
            for(int BOUND=N; BOUND>1; BOUND--){
                for(int m=1; m<=BOUND-1; m++){
                    if(D[i][m] > D[i][m+1]){
                        tempDigit = D[i][m];
                        D[i][m] = D[i][m+1];
                        D[i][m+1] = tempDigit;

                        temp = K[m];
                        K[m] = K[m+1];
                        K[m+1] = temp;
                    }
                }
            }

            System.out.println("The "+i+" digit sorted Ks:");
            for(int n=1; n<=N; n++){
                System.out.println(n+":"+K[n]);
            }
            System.out.println();
        }

        //Output sorted Ks
        System.out.println("Final sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
