import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N;
    String[][] map;
    boolean[][] visited;
    boolean[][] colorVisited;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    List<Integer> notColor = new ArrayList<>();
    List<Integer> seeColor = new ArrayList<>();

    public void sol() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visited = new boolean[N][N];
        colorVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j])
                    bfs(i,j,map[i][j]);
            }
        }
        for (int i = 0; i < N; i++) { // 적록색약으로 만들기
            for (int j = 0; j < N; j++) {
                if(map[i][j].equals("G"))
                    map[i][j] = "R";
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!colorVisited[i][j])
                    cantseebfs(i,j,map[i][j]);
            }
        }

        System.out.println(seeColor.size() +" " +  notColor.size());
    }

    public void bfs(int x,int y, String color) {
        Queue<int[]> q = new LinkedList<>();
        int area=0;
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = xy[0] + dx[k];
                int ny = xy[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(map[nx][ny].equals(color) && !visited[nx][ny]){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        seeColor.add(area);
    }

    public void cantseebfs(int x,int y, String color) {
        Queue<int[]> q = new LinkedList<>(); // 적록색약인 사람들
        int area=0;
        q.add(new int[]{x, y});
        colorVisited[x][y] = true;
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = xy[0] + dx[k];
                int ny = xy[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(map[nx][ny].equals(color) && !colorVisited[nx][ny]){
                        q.add(new int[]{nx, ny});
                        colorVisited[nx][ny] = true;
                    }
                }
            }
        }
        notColor.add(area);
    }

    public void show() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
