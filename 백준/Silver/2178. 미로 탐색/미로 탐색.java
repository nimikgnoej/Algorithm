import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Queue<int[]> q = new LinkedList<>();
    int[][] map;
    boolean[][] visited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int n,m;
    int[][] dest;


    public void sol() throws Exception {
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);

        map = new int[n + 1][m + 1];
        visited = new boolean[n+1][m+1];
        dest = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                map[i][j+1] = input.charAt(j) - '0';
            }
        }
        bfs(1, 1);
        System.out.println(dest[n][m]);
        br.close();
    }



    public void bfs(int x,int y){
        q.add(new int[]{x,y});
        visited[x][y] = true;
        dest[x][y]=1;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>0 && ny>0 && nx<=n && ny<=m){
                    if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        dest[nx][ny] = dest[x][y]+1;
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
