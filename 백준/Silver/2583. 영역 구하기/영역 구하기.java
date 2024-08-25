import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Queue<int[]> q = new ArrayDeque<>();
    int m,n,k;
    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    List<Integer> areaList = new ArrayList<>();

    public void sol() throws Exception {
        String[] split = br.readLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int startX = Integer.parseInt(input[0]);
            int startY = Integer.parseInt(input[1]);
            int endX = Integer.parseInt(input[2]);
            int endY = Integer.parseInt(input[3]);
            fill(startX, startY, endX, endY);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        Collections.sort(areaList);
        System.out.println(areaList.size());
        for (int i = 0; i < areaList.size(); i++) {
            if(i != areaList.size()-1)
                System.out.print(areaList.get(i)+" ");
            else
                System.out.println(areaList.get(i));
        }
    }

    public void fill(int startX, int startY, int endX, int endY) {
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                map[m-i-1][j] = 1;
            }
        }
    }

    public void show() {
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int x, int y) {
        int area = 1;
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] start = q.poll();
            x=start[0];
            y=start[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        area++;
                    }
                }
            }
        }
        areaList.add(area);
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
