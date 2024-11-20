import java.util.*;
import java.io.*;

class Solution {
    
    public boolean[] visited;
    public Queue<Integer> q = new LinkedList<>();
    public int[][] copy;
    public int count=0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        copy = computers;
        
        for(int i=0;i<n;i++){
            if(!visited[i])
                bfs(i);
        }
        
        return count;
    }
    
    public void bfs(int x){
        q.add(x);
        visited[x]=true;
        while(!q.isEmpty()){
            x = q.poll();
            for(int i=0;i<copy.length;i++){
                if(copy[x][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        count++;
    }
}