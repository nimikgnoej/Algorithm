import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] map;
    public static long[] dist;
    public static boolean[] visited;
    static int n,m;

    public static void main(String[] args) throws IOException {
        Main.sol();
    }

    public static void sol() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Integer.MAX_VALUE-1; // infinite
            }
        }

        for (int i = 0; i < m; i++) {
            String[] st = br.readLine().split(" ");
            int start = Integer.parseInt(st[0]);
            int end = Integer.parseInt(st[1]);
            int cost = Integer.parseInt(st[2]);
            if(map[start][end]!=-1) map[start][end] = Math.min(map[start][end], cost);
            else map[start][end] = cost;
        }

        String[] stend =  br.readLine().split(" ");
        int start = Integer.parseInt(stend[0]);
        int end = Integer.parseInt(stend[1]);
        dijkstra(n, start);
        System.out.println(dist[end]);
    }

    public static void dijkstra(int n, int start) {
        dist = new long[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i < n+1; i++) {
            dist[i] = map[start][i];
        }
        visited[start] = true;

        for (int i = 0; i < n -1; i++) {
            int now = minIdx();
            visited[now] = true;
            for(int j = 1; j < n+1; j++) {
                if(!visited[j]){
                    if(dist[now] + map[now][j] < dist[j]){
                        dist[j] = dist[now] + map[now][j];
                    }
                }
            }
        }
    }

    public static int minIdx() {
        long min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] < min && !visited[i]) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }
}