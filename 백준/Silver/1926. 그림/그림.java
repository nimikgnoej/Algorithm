import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] map = new int[501][501];
    boolean[][] visited = new boolean[501][501];
    int n;
    int m;
    Queue<int[]> q = new LinkedList<>();
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    List<Integer> area = new ArrayList<>();

    public void sol() throws Exception {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(area.size());
        sb.append("\n");

        sb.append(maxArea());
        System.out.print(sb);
    }

    public int maxArea() {
        if(area.isEmpty()){
            area.add(0);
        }
        int max = area.get(0);
        for (int i = 0; i < area.size(); i++) {
            if (max < area.get(i)) {
                max= area.get(i);
            }
        }
        return max;
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start, int end) {
        int count = 1;
        q.add(new int[]{start, end});
        visited[start][end] = true;
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }
        area.add(count);
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
