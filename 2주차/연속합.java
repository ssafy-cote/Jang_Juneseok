import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (dp[i - 1] + num < 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + num;
            }
            max = Math.max(num, Math.max(max, dp[i - 1] + num));
        }

        for (int i = 0; i < n; i++) {
            sum += dp[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}