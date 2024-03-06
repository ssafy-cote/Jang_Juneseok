import java.util.Scanner;

public class Main {

    public static int tileing(int[] dp, int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        if (n == 1) {
            return dp[1] = 1;
        } else if (n == 2) {
            return dp[2] = 2;
        }
        return dp[n] = (tileing(dp, n-2) + tileing(dp,n-1)) % 15746;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];

        System.out.println(tileing(dp, N));

        //1
        //00, 11
        //100 001 111
        //1100 0011 1111 0000 1001
        //11100 11001 10011 00111 10011 11111 10000 00001
    }
}
