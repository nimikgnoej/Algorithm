import java.util.*;
import java.io.*;

class Solution {
    
    public int[] nInfo;
    public int[][] nEdges;
    public boolean[] visited;
    public int maxSheep=0;
    
    public int solution(int[] info, int[][] edges) {
        nInfo = info;
        nEdges = edges;
        visited = new boolean[info.length];
        
        dfs(0,visited,0,0);
        return maxSheep;
    }
    
    public void dfs(int i, boolean[] visited,int sheep, int wolf){
        visited[i] = true;
        if(nInfo[i]==0){
            sheep++;
            maxSheep = Math.max(sheep, maxSheep);
        }
        else wolf++;
    
        
        if(wolf>=sheep){
            return;
        }

        for(int[] edge : nEdges){
            if(visited[edge[0]] && !visited[edge[1]]){
                boolean[] nextVisited = new boolean[visited.length];
                for(int x=0;x<visited.length;x++)
                    nextVisited[x] = visited[x];
                dfs(edge[1],nextVisited,sheep,wolf);
            }
                
        }
    }
}