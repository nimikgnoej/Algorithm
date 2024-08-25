import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        final int MAX = 1000001;
        int target = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3;i<=target;i++){
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i / 2] + 1, dp[i - 1] + 1));
            }
            else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else {
                dp[i] = dp[i-1]+1;
            }
        }

        System.out.println(dp[target]);
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
