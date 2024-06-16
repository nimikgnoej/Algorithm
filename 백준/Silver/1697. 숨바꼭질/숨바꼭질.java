import java.util.*;
import java.io.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int MAX = 100001;
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[200001];
    int[] time = new int[200001];

    public void sol() throws Exception {
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        bfs(n, k);
        System.out.println(time[k]);

        br.close();
    }

    public void bfs(int start, int end) {
        q.add(start);
        visited[start] = true;
        time[start] = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            if(x-1 >= 0 && !visited[x - 1]){
                q.add(x-1);
                visited[x - 1] = true;
                time[x-1] = time[x] + 1;
                if(x-1 == end){
                    return;
                }
            }
            if(x+1 <= MAX && !visited[x + 1]){
                q.add(x + 1);
                visited[x + 1] = true;
                time[x+1] = time[x] + 1;
                if(x-1 == end){
                    return;
                }
            }
            if (2 * x <= MAX && !visited[2 * x]) {
                q.add(2 * x);
                visited[2 * x] = true;
                time[2*x] = time[x] + 1;
                if(x-1 == end){
                    return;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        new Main().sol();
    }
}
