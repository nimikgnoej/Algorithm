import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int garo,sero,h;
    int[][][] map;
    boolean[][][] visited;
    int[][][] dist;
    Queue<int[]> q = new LinkedList<>();
    int[] dx = {-1, 0, 1, 0, 0, 0};
    int[] dy = {0, 1, 0, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, 1, -1};

    public void sol() throws Exception {
        String[] split = br.readLine().split(" ");
        garo = Integer.parseInt(split[0]);
        sero = Integer.parseInt(split[1]);
        h = Integer.parseInt(split[2]);
        map = new int[garo+1][sero+1][h+1];
        visited = new boolean[garo+1][sero+1][h+1];
        dist = new int[garo+1][sero+1][h+1];

        for(int i=1;i<=h;i++){
            for(int j=1;j<=sero;j++){
                String[] input = br.readLine().split(" ");
                for(int k=0;k< garo;k++){
                    map[k+1][j][i] = Integer.parseInt(input[k]);
                }
            }
        }

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= sero; j++){
                for(int k = 1; k <= garo; k++){
                    if (map[k][j][i] == 1 && visited[k][j][i] == false) {
                        q.add(new int[]{k, j, i});
                    }
                }
            }
        }
        bfs();
        if (hasZero()) { // 0이 있다면 안익은 토마토 있음
            System.out.println("-1");
        } else {
            int max = max();
            System.out.println(max-1);
        }
        br.close();
    }

    public boolean hasZero() {
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= sero; j++){
                for(int k = 1; k <= garo; k++){
                    if(map[k][j][i]==0)
                        return true;
                }
            }
        }
        return false;
    }

    public int max(){
        int max = 0;
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= sero; j++){
                for(int k = 1; k <= garo; k++){
                    if (map[k][j][i] > max)
                        max = map[k][j][i];
                }
            }
        }
        return max;
    }

    public void bfs() {
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int z = tmp[2];
            for (int k = 0; k < 6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nz = z + dz[k];
                if(nx>0 && ny>0 && nz>0 && nx<=garo && ny<=sero && nz<=h){
                    if(map[nx][ny][nz] == 0 && visited[nx][ny][nz] == false){
                        q.add(new int[]{nx, ny, nz});
                        visited[nx][ny][nz] = true;
                        map[nx][ny][nz] = map[x][y][z] + 1;
                    }
                }
            }
        }
    }

    public void show() {
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= sero; j++){
                for(int k = 1; k <= garo; k++){
                    System.out.print(map[k][j][i] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
