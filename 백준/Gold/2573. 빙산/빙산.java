import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int[][] zeroCount;
    static int iceburg=0;
    static int years=0;

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Main.sol();
    }

    public static void sol() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] ices = br.readLine().split(" ");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(ices[j]);
            }
        }

        while (true) {
            iceburg=0;
            visited = new boolean[n][m];
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    if(map[i][j] != 0 && !visited[i][j])
                        bfs(i,j);
                }
            }

            if(iceburg>=2){
                System.out.println(years);
                break;
            }
            calculateZero();
            melt();
            if(checkZero()){
                System.out.println("0");
                break;
            }

            years++;
        }
    }

    public static boolean checkZero(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]!=0)
                    return false;
            }
        }
        return true;
    }

    public static void bfs(int x, int y) {
        q.add(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] xy = q.poll();
            x=xy[0];
            y=xy[1];
            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(map[nx][ny] != 0 && visited[nx][ny] == false){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        iceburg++;
    }

    public static void calculateZero() {
        zeroCount = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] != 0){
                    for(int k=0;k<4;k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<n && ny>=0 && ny<m)
                            if(map[nx][ny] == 0) zeroCount[i][j]++;
                    }
                }
            }
        }
    }

    public static void melt() {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] - zeroCount[i][j] < 0)
                    map[i][j] = 0;
                else map[i][j] = map[i][j] - zeroCount[i][j];
            }
        }
    }

    public static void show(int[][] map) {
        for(int i =0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }


}