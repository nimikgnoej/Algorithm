import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[20];
        int[] P = new int[20];
        int[] dp = new int[20];
        for(int i=1;i<=N;i++){
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        for (int i = N; i >= 1; i--) {
            if (N + 1 - i < T[i]) {
                dp[i] = dp[i + 1];
            } else if (N + 1 - i >= T[i]) {
                dp[i] = Math.max(dp[i + T[i]] + P[i], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
        
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
