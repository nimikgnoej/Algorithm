import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long[] dp = new long[100];

    public void sol() throws Exception {
        int num = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        sb.append(dp[num]);
        System.out.println(sb);

        br.close();
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
