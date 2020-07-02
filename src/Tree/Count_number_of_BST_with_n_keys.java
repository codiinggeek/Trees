package Tree;

import java.util.Scanner;

/**
 * for explanation: https://www.youtube.com/watch?v=kT_VabdscHk&feature=youtu.be
 */
public class Count_number_of_BST_with_n_keys {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar[] = new int[n+1];
        ar[0] = ar[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                ar[i] += ar[j]*ar[i-j-1];
            }
        }
        System.out.println("Count: "+ar[n]);
    }
}
