public class Main {

    public static void main(String[] args) {
        int N = 16;
        String[] K = new String[17];
        int m = 10;                       /*Total number of bits in the Ks*/
        int[] R = new int[10];            /*At most m-1*/
        int[] B = new int[10];            /*At most m-1*/

        /*Prepare the input data*/
        K[1] = Integer.toBinaryString(503);
        K[2] = Integer.toBinaryString(87);
        K[3] = Integer.toBinaryString(512);
        K[4] = Integer.toBinaryString(61);
        K[5] = Integer.toBinaryString(908);
        K[6] = Integer.toBinaryString(170);
        K[7] = Integer.toBinaryString(897);
        K[8] = Integer.toBinaryString(275);
        K[9] = Integer.toBinaryString(653);
        K[10] = Integer.toBinaryString(426);
        K[11] = Integer.toBinaryString(154);
        K[12] = Integer.toBinaryString(509);
        K[13] = Integer.toBinaryString(612);
        K[14] = Integer.toBinaryString(677);
        K[15] = Integer.toBinaryString(765);
        K[16] = Integer.toBinaryString(703);

        /*Transform Decimal to Binary(all 10bits in this example) and output unsorted Ks*/
        System.out.println("Unsorted Ks:");
        for(int i=1; i<=N; i++){
            if(K[i].length() < 10){
                switch (10 - K[i].length()){
                    case 1: K[i] = "0" + K[i]; break;
                    case 2: K[i] = "00" + K[i]; break;
                    case 3: K[i] = "000" + K[i]; break;
                    case 4: K[i] = "0000" + K[i]; break;
                    case 5: K[i] = "00000" + K[i]; break;
                    case 6: K[i] = "000000" + K[i]; break;
                    case 7: K[i] = "0000000" + K[i]; break;
                    case 8: K[i] = "00000000" + K[i]; break;
                    case 9: K[i] = "000000000" + K[i]; break;
                }
            }
            System.out.println(String.format("%3s", i+":")+String.format("%11s", K[i])+":"+Integer.parseInt(K[i], 2));
        }
        System.out.println();

        /*Kernel of the Algorithm!*/
        int l = 1;                              /*R1*/
        int r = N;
        int b = 1;
        int len = 0;
        int i;
        int j;
        String temp;

        do{
            do{
                if(l == r){                          /*R2*/
                    break;
                }else {
                    i = l;
                    j = r;
                }
                do{
                    if(K[i].charAt(b-1) == '1'){        /*R3*/
                        do{
                            j--;                            /*R6*/
                            if(i <= j){
                                if(K[j+1].charAt(b-1) == '0'){   /*R5*/
                                    temp = K[i];                /*R7*/
                                    K[i] = K[j+1];
                                    K[j+1] = temp;
                                    break;
                                }
                            }else {
                                break;
                            }
                        }while (true);
                        if(i > j){
                            break;
                        }
                    }
                        i++;                   /*R4*/
                        if(i <= j){
                            /*Go to R3*/
                        }else {
                            break;/*Go to R8*/
                        }
                }while (true);
                b++;                         /*R8*/
                if(b > m){
                    break;
                }else if(j < l || j == r){
                    /*Go to R2*/
                }else if(j == l){
                    l++;
                    /*Go to R2*/
                }else {
                    len++;
                    R[len] = r;             /*R9*/
                    B[len] = b;
                    r = j;
                }
            }while (true);
            if(len == 0){             /*R10*/
                break;
            }else {
                l = r+1;
                r = R[len];
                b = B[len];
                len--;
            }
        }while (true);

        /*Output sorted Ks*/
        System.out.println("Sorted Ks:");
        for(i=1; i<=N; i++){
            System.out.println(String.format("%3s", i+":")+String.format("%11s", K[i])+":"+Integer.parseInt(K[i], 2));   /*Transform Binary to Decimal*/
        }
    }
}