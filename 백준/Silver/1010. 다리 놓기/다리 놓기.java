import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] dp = new int[30][30];

    public void sol() throws Exception {
       int tc = Integer.parseInt(br.readLine());
       for(int i=0;i<30;i++){
           dp[i][i] = 1;
           dp[i][0] = 1;
       }

       for(int i=2;i<30;i++){
           for (int j = 1; j < 30; j++) {
               dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
           }
       }

        while (tc-- > 0) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            sb.append(dp[m][n]).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
