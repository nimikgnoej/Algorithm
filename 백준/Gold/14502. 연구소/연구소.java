import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int wallCnt = 3;
    public int[][] map;
    public int[][] copyMap;
    public int n, m;

    public Queue<int[]> q = new LinkedList<>();
    public boolean[][] visited;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public List<Integer> answer = new ArrayList<>();

    public void sol() throws Exception {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];
        copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        makeWall();
        if(!answer.isEmpty()){
            int max = answer.get(0);
            for (int x = 1; x < answer.size(); x++) {
                if(max < answer.get(x))
                    max = answer.get(x);
            }
            System.out.println(max);
        } else {
            System.out.println(0);
        }

    }

    public void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            visited[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copyMap[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        copyMap[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public int countZero() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0)
                    count++;
            }
        }
        return count;
    }

    public void copyTheMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }


    public void makeWall() {
        if (wallCnt == 0) {
            copyTheMap();
            visited = new boolean[n][m];
            bfs();
            int cnt = countZero();
            if(cnt != 0)
                answer.add(cnt);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    wallCnt--;
                    map[i][j] = 1;
                    makeWall();
                    wallCnt++;
                    map[i][j] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
