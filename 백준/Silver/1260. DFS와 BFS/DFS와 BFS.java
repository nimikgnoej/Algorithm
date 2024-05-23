import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public boolean[] check = new boolean[1001];
    public int[][] map = new int[1001][1001];
    public int n,m,start;

    public Queue<Integer> q = new LinkedList<>();

    public void sol() throws Exception {
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        start = Integer.parseInt(split[2]);

        while (m-- > 0) {
            String[] split1 = br.readLine().split(" ");
            int from = Integer.parseInt(split1[0]);
            int to = Integer.parseInt(split1[1]);
            map[from][to] = 1;
            map[to][from] = 1;
        }
        dfs(start);
        System.out.println(sb);
        
        sb.setLength(0);
        for(int i = 0; i <= n; i++)
            check[i] = false;

        bfs(start);
        System.out.println(sb);
        br.close();
    }


    public void dfs(int x){
        check[x] = true;
        sb.append(x).append(" ");
        for (int i = 0; i < n + 1; i++) {
            if (map[x][i] == 1 && check[i] == false)
                dfs(i);
        }
    }

    public void bfs(int x){
        q.add(x);
        check[x] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            sb.append(front).append(" ");
            for(int i=0;i<n+1;i++){
                if(map[front][i] == 1 && check[i] == false){
                    q.add(i);
                    check[i]=true;
                }
            }
        }
    }



    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
