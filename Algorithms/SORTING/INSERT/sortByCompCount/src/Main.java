public class Main {

    //Sorting by counting:Comparison counting
    public static void main(String[] args) {
        int N = 16;
        int[] keys = new int[17];
        int[] COUNT = new int[17];

        //Prepare the data
        keys[1] = 503;
        keys[2] = 87;
        keys[3] = 512;
        keys[4] = 61;
        keys[5] = 908;
        keys[6] = 170;
        keys[7] = 897;
        keys[8] = 275;
        keys[9] = 653;
        keys[10] = 426;
        keys[11] = 154;
        keys[12] = 509;
        keys[13] = 612;
        keys[14] = 677;
        keys[15] = 765;
        keys[16] = 703;

        //Output unsorted keys
        System.out.println("Unsorted keys:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+keys[i]);
        }
        System.out.println();

        //Clear COUNTs
        for(int i=1; i<=N; i++){
            COUNT[i] = 0;
        }

        //Kernel of the Algorithm
        for(int i=N; i>1; i--){
            for(int j=i-1; j>=1; j--){
                if(keys[i] < keys[j]){
                    COUNT[j]++;
                }else{
                    COUNT[i]++;
                }
            }
        }

        //Output final COUNTs
        System.out.println("COUNT values:");
        for(int i=1; i<=N; i++){
            System.out.println("COUNT["+i+"]="+COUNT[i]);
        }
        System.out.println();

        //Output sorted keys
        System.out.println("Sorted keys:");
        for(int i=0; i<=N-1; i++){
            for(int j=1; j<=N; j++){
                if(COUNT[j] == i){
                    System.out.println((COUNT[j]+1)+":"+keys[j]);
                }
            }
        }
    }
}
