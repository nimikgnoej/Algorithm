import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dp = new int[1001];

    public void sol() throws Exception {
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1; // 홀수(1) 일때는 SK
        dp[2] = 2; // 짝수(2) 일때는 CY
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-1]) + 1;
        }
        if (dp[n] % 2 == 0) {
            System.out.print("CY");
        } else {
            System.out.print("SK");
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
