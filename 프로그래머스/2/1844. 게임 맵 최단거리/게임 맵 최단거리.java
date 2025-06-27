import java.util.*;
import java.io.*;

class Solution {
    
    private Queue<int[]> q = new LinkedList<>();
    private int[][] visited;
    private int[] dx = {0,1,0,-1};
    private int[] dy = {1,0,-1,0};
    private int N;
    private int M;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];
        
        bfs(maps);
        if(visited[N-1][M-1] == 1) return maps[N-1][M-1];
        else return -1;
    }
    
    private void bfs(int[][] maps) {
        q.add(new int[]{0,0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            for(int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(maps[nx][ny]!=0 && visited[nx][ny]==0){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = 1;
                        maps[nx][ny] = maps[x][y]+1;
                    }
                }
            }
        }
    }
    
    private void showMaps(int[][] maps){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(maps[i][j]+ " ");
            }
            System.out.println();
        }
    }
}