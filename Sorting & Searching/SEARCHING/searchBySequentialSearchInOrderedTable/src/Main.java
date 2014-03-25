/**
 * Created with IntelliJ IDEA.
 * User: 1O1O
 * Date: 12/8/13
 * Time: 6:52 PM
 * :)~
 * Radix List Sort:Sorting by Distribution:Internal Sorting
 */
public class Main {

    public static void main(String[] args) {
        int N = 16;
        int[] K = new int[18];

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
        K[N+1] = 10000;              /*Positive infinite*/

        for(i=1; i<=N+1; i++){
            if(Key <= K[i]){
                break;
            }
        }
        if(Key == K[i]){
            System.out.println("Outputs: "+Key+" in K["+i+"].");
        }else {
            System.out.println("Outputs: "+Key+" not found.");
        }
    }
}