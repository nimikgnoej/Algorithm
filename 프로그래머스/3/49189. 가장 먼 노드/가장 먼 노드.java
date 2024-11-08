import java.util.*;
import java.io.*;

class Solution {
    
    public int[][] edge;
    public boolean[] visited;
    public Queue<Integer> q = new LinkedList<>();
    public int[] dist;
    
    public int solution(int n, int[][] map) {
        int ans = 0;
        edge = map;
        visited = new boolean[n+1];
        dist = new int[n+1];
        // for(int i=0;i<edge.length;i++){
        //     int from = edge[i][0];
        //     int to = edge[i][1];
        //     map[from][to] = 1;
        //     map[to][from] = 1;
        // }
        
        bfs(1);
        // for(int i=1;i<=6;i++) System.out.print(dist[i] + " ");
        Arrays.sort(dist);
        int max = dist[n];
        for(int i=1;i<=n;i++)
            if(max==dist[i]) ans++;
        return ans;
    }
    
    public void bfs(int x){
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()){
            x = q.poll();
            for(int i=0;i<edge.length;i++){
                if(edge[i][0] == x && !visited[edge[i][1]]){ // 연결되어 있고 방문한 적 없으면
                    q.add(edge[i][1]);
                    visited[edge[i][1]] = true;
                    dist[edge[i][1]] = dist[x] + 1;
                } else if(edge[i][1] == x && !visited[edge[i][0]]){
                    q.add(edge[i][0]);
                    visited[edge[i][0]] = true;
                    dist[edge[i][0]] = dist[x] + 1;
                }
            }
        }
    }
}