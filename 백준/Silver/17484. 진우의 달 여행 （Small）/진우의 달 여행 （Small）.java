import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int[] dy = {1, 0, -1};
    public static boolean[] dyUsed = new boolean[3];
    public static Queue<int[]> q = new LinkedList<>();
    public static int[][][] dp;
    public static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int k = 0; k < M; k++) {
            dp[0][k][0] = map[0][k];
            dp[0][k][1] = map[0][k];
            dp[0][k][2] = map[0][k];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]);
                    dp[i][j][1] = map[i][j] + dp[i - 1][j][0];
                } else if (j == M - 1) {
                    dp[i][j][2] = map[i][j] + Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
                    dp[i][j][1] = map[i][j] + dp[i - 1][j][2];
                } else {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]);
                    dp[i][j][1] = map[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    dp[i][j][2] = map[i][j] + Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                answer.add(dp[N - 1][i][j]);
            }
        }
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }

}

