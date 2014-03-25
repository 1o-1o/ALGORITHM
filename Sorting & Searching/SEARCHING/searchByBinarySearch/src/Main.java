/**
 * Created with IntelliJ IDEA.
 * User: 1O1O
 * Date: 12/10/13
 * Time: 6:52 PM
 * :)~
 * Binary Search
 */
public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[17];

        /*Prepare the ordered data table*/
        K[1] = 61;
        K[2] = 87;
        K[3] = 154;
        K[4] = 170;
        K[5] = 275;
        K[6] = 426;
        K[7] = 503;
        K[8] = 509;
        K[9] = 512;
        K[10] = 612;
        K[11] = 653;
        K[12] = 677;
        K[13] = 703;
        K[14] = 765;
        K[15] = 897;
        K[16] = 908;

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(int i=1; i<=N; i++){
            System.out.println(i+":"+K[i]);
        }
        System.out.println();

        /*Kernel of the Algorithm!*/
        int Key = 653;               /*Key to be found*/
        int i;
        int l = 1;
        int u = N;

        do{
            if(u < l){
                System.out.println("Outputs: "+Key+" not found.");
                break;
            }else {
                i = (int)Math.floor((double)(l+u)/2);
            }
            if(Key < K[i]){
                u = i-1;
            }else if(Key > K[i]){
                l = i+1;
            }else{
                System.out.println("Outputs: "+Key+" in K["+i+"].");
                break;
            }
        }while (true);
    }
}