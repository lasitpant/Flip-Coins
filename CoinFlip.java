import java.util.Scanner;

/**
 * Created by Lasit on 1/18/2017.
 */
public class CoinFlip {
    public static int solution(int[] coins) {
        if (coins.length == 0) {
            return 0;
        }

        for (int i = 1; i < coins.length - 1; i++) {
            if (coins[i - 1] != coins[i] && coins[i] != coins[i + 1]) { // 010 or 101
                coins[i] = coins[i] == 1 ? 0 : 1;
                return adjacency(coins);
            }
        }

        for (int i = 1; i < coins.length - 1; i++) {
            if (coins[i - 1] == coins[i] && coins[i] != coins[i + 1]) {
                coins[i + 1] = coins[i + 1] == 1 ? 0 : 1;
                return adjacency(coins);
            } else if (coins[i - 1] != coins[i] && coins[i] == coins[i + 1]) {
                coins[i - 1] = coins[i - 1] == 1 ? 0 : 1;
                return adjacency(coins);
            }
        }

        coins[0] = coins[0] == 1 ? 0 : 1;
        return adjacency(coins);
    }

    private static int adjacency(int[] A) {
        int adj = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                adj++;
            }
        }
        int fin= A.length-adj;
        return fin;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){
           arr[i]= sc.nextInt();
        }
        int z= flipCoin(arr);

        System.out.println(z);


    }

}