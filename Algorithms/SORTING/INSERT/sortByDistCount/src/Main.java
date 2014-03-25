public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] S = new int[17];
        int[] keys = new int[17];
        int[] COUNT = new int[62];
        int u = 3;
        int v = 61;

        //Prepare the data,3<=keys<=61
        keys[1] = 3;
        keys[2] = 57;
        keys[3] = 12;
        keys[4] = 61;
        keys[5] = 8;
        keys[6] = 17;
        keys[7] = 7;
        keys[8] = 25;
        keys[9] = 53;
        keys[10] = 42;
        keys[11] = 14;
        keys[12] = 9;
        keys[13] = 12;
        keys[14] = 46;
        keys[15] = 50;
        keys[16] = 27;

        //Output unsorted keys
        System.out.println("Unsorted keys:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+keys[i]);
        }
        System.out.println();

        //Clear COUNTs
        for(int i=u; i<=v; i++){
            COUNT[i] = 0;
        }

        //Kernel of the Algorithm
        for(int j=1; j<=N; j++){
            COUNT[keys[j]]++;
        }
        for(int i=u+1; i<=v; i++){
            COUNT[i] = COUNT[i] + COUNT[i-1];
        }
        for(int j=N; j>=1; j--){
            int i = COUNT[keys[j]];
            S[i] = keys[j];
            COUNT[keys[j]] = i-1;
        }

        //Output sorted keys
        System.out.println("Sorted keys:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+S[i]);
        }
    }
}
