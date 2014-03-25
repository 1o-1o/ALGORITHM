public class Main {
    public static void iJPosition(int[] K, int[] L, int[] R,int len, int l, int r, int M, int i, int j, int Key){
        do{
            i++;
            if(K[i] >= Key){
                break;
            }
        }while (i <= j);

        do{
            j--;
            if(Key >= K[j]){
                break;
            }
        }while (j >= i-1);

        if(j <= i){
            int temp = K[l];
            K[l] = K[j];
            K[j] = temp;

            if(r-j >= j-l && j-l > M){
                len++;
                L[len] = j+1;
                R[len] = r;
                r = j-1;
            }else if(j-l > r-j && r-j > M){
                len++;
                L[len] = l;
                R[len] = j-1;
                l = j+1;
            }else if(r-j > M && M >= j-l){
                l = j+1;
            }else if(j-l > M && M >= r-j){
                r = j-1;
            }
            quickSort(K, L, R, len, l, r, M);
        }else {
            int temp = K[i];
            K[i] = K[j];
            K[j] = temp;
            iJPosition(K, L, R, len, l, r, M, i, j, Key);
        }
    }

    public static void quickSort(int[] K, int[] L, int[]R, int len, int l, int r, int M){
        int i = l;
        int j = r+1;
        int Key = K[l];

        iJPosition(K, L, R, len, l, r, M, i, j, Key);
    }

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[18];
        int[] L = new int[4];
        int[] R = new int[4];
        int temp;
        int len = 0;
//        L[0] = N;
//        L[N] = 0;

        //Prepare the data
        K[0] = -10000;
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
        K[17] = 10000;

        //Output unsorted Ks
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        //Kernel of the Algorithm!
        int M = 1;
        if(N <= M){

        }else {
            int l = 1;
            int r = N;

            do{
                quickSort(K, L, R, len, l, r, M);
                l = L[len];
                r = R[len];
                len--;
            }while (len > 0);

        }




        //Output sorted Ks
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}