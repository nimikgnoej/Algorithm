import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Queue<Integer> q = new LinkedList<>();
    int[][] map;
    boolean[] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n,m,cnt;

    public void sol() throws Exception {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n+1];

        for(int i = 1; i <= m; i++) {
            String[] com = br.readLine().split(" ");
            int from = Integer.parseInt(com[0]);
            int to = Integer.parseInt(com[1]);
            map[from][to] = 1;
            map[to][from] = 1;
        }
        bfs(1);
        System.out.println(cnt);

        br.close();
    }



    public void bfs(int start){
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            start = q.poll();
            for (int i = 1; i <= n; i++) {
                if(map[start][i] == 1 && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
