public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];
        Double t = Math.ceil(Math.log(N)/Math.log(2));
        int temp;


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
        for(int p=(int)Math.pow(2, t-1); p>0; p=(int)Math.floor(p/2)){
            int q = (int)Math.pow(2, t-1);
            int r = 0;
            int d = p;

            for(int i=0; i<N-d; i++){
                if((i & p) == r){
                    if(K[i+1] > K[i+d+1]){
                        temp = K[i+1];
                        K[i+1] = K[i+d+1];
                        K[i+d+1] = temp;
                    }
                }
            }

            while (q > p){
                d = q - p;
                q /= 2;
                r = p;
                for(int i=0; i<N-d; i++){
                    if((i & p) == r){
                        if(K[i+1] > K[i+d+1]){
                            temp = K[i+1];
                            K[i+1] = K[i+d+1];
                            K[i+d+1] = temp;
                        }
                    }
                }
            }
        }

        //Output sorted Ks
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
