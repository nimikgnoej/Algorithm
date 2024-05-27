import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n,from,to,m;
    int[][] map;
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited;
    int[] dist;

    public void sol() throws Exception {
        n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        from = Integer.parseInt(split[0]);
        to = Integer.parseInt(split[1]);
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];

        while (m-- > 0) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            map[x][y] = 1;
            map[y][x] = 1;
        }
        bfs(from);
        if(dist[to] != 0)
            System.out.println(dist[to]);
        else
            System.out.println("-1");
        br.close();
    }


    public void bfs(int start) {
        q.add(start);
        visited[start] = true;
        dist[start] = 0;
        while (!q.isEmpty()) {
            start = q.poll();
            for (int i = 1; i <= n; i++) {
                if (map[start][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                    dist[i] = dist[start] + 1;
                }
            }
        }
    }

    public void show() {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
