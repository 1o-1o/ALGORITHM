public class Main {

    public static int LEFT(int i){
        return 2*i;
    }

    public static int RIGHT(int i){
        return 2*i+1;
    }

    public static void MAX_HEAPIFY(int[] K, int i, int heapSize){
        int l = LEFT(i);
        int r = RIGHT(i);
        int largest;
        int temp;
        if(l <= heapSize && K[l] > K[i]){
            largest = l;
        }else {
            largest = i;
        }
        if(r <= heapSize && K[r] > K[largest]){
            largest = r;
        }
        if(largest != i){
            temp = K[largest];
            K[largest] = K[i];
            K[i] = temp;
            MAX_HEAPIFY(K, largest, heapSize);
        }
    }

    public static void BUILD_MAX_HEAP(int[] K, int heapSize){
        for(int i=(int)Math.floor((K.length-1)/2); i>=1; i--){
            MAX_HEAPIFY(K, i, heapSize);
        }
    }

    public static void HEAPSORT(int[] K){
        int heapSize = K.length-1;
        int temp;
        BUILD_MAX_HEAP(K, heapSize);
        for(int i=K.length-1; i>=2; i--){
            temp = K[i];
            K[i] = K[1];
            K[1] = temp;
            heapSize--;
            MAX_HEAPIFY(K, 1, heapSize);
        }
    }

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];

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
        HEAPSORT(K);

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
    }
}
