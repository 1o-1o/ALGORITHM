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
        int Key = 653;                  /*Key to be found*/
        K[0] = -10000;                /*Negative Infinite*/
        int i = (int)Math.floor((N+Math.pow(2, 1-1))/Math.pow(2, 1));
        int j = 2;
        int deltaJ;

        do{
            deltaJ = (int)Math.floor((N+Math.pow(2, j-1))/Math.pow(2, j));
            if(Key < K[i]){
                if(deltaJ == 0){
                    System.out.println("Outputs: "+Key+" not found.");
                    break;
                }else {
                    i = i-deltaJ;
                    j++;
                }
            }else if(Key > K[i]){
                if(deltaJ == 0){
                    System.out.println("Outputs: "+Key+" not found.");
                    break;
                }else {
                    i = i+deltaJ;
                    j++;
                }
            }else {
                System.out.println("Outputs: "+Key+" in K["+i+"].");
                break;
            }
        }while (true);
    }
}