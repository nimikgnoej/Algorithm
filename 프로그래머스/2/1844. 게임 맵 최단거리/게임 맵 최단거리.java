import java.util.*;

class Solution {
    private static Queue<int[]> q = new ArrayDeque<>();
    private static boolean[][] visited = new boolean[101][101];
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public void bfs(int x, int y, int[][] maps) {
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] xy = q.poll();
            x = xy[0];
            y = xy[1];
            for (int k = 0; k < 4; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                    if (maps[nx][ny] != 0 && !visited[nx][ny]) {
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[x][y] + 1;
                    }
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        bfs(0, 0, maps);
        return maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
    }
}