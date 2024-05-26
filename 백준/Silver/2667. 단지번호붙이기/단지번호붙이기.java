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
    int n,danji;
    int house;
    List<Integer> answer = new ArrayList<>();

    public void sol() throws Exception {
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++){
            String in = br.readLine();
            for (int j = 0; j < in.length(); j++) {
                map[i][j+1] = in.charAt(j) - '0';
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 1 && visited[i][j] == false){
                    bfs(i, j);
                    danji++;
                    answer.add(house);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        System.out.println(danji);
        for (int i = 0; i < danji; i++) {
            System.out.println(answer.get(i));
        }

        System.out.println();

        br.close();
    }


    public void bfs(int x, int y) {
        house=1;
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 < nx && 0 < ny && nx <= n && ny <= n) {
                    if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        house++;
                    }
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
