import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void sol() throws Exception {
        int num = Integer.parseInt(br.readLine());
        int[] box = new int[num];
        int[] dp = new int[1001];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            box[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < num; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = maximum(dp);
        System.out.println(ans);

    }

    public int maximum(int[] dp) {
        int maxNum = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxNum < dp[i]) {
                maxNum = dp[i];
            }
        }
        return maxNum;
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
