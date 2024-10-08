import java.util.*;
import java.io.*;

class Solution {

    String[][] map = new String[5][5];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            boolean isAns = true;
            
            // 5x5 맵을 map 배열로 변환
            for (int j = 0; j < 5; j++) {
                String[] str = places[i][j].split("");
                for (int k = 0; k < 5; k++)
                    map[j][k] = str[k];
            }

            // BFS를 모든 'P'에서 탐색
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (map[x][y].equals("P")) {
                        if (!bfs(x, y)) {  // 하나라도 false이면 바로 중단
                            isAns = false;
                            break;
                        }
                    }
                }
                if (!isAns) break; // 중간에 false가 나오면 더 이상 탐색하지 않음
            }

            if (isAns) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];  // 방문 여부 체크
        
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int curX = xy[0];
            int curY = xy[1];

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visited[nx][ny]) {
                    visited[nx][ny] = true;  // 방문 표시

                    int distance = Math.abs(nx - x) + Math.abs(ny - y);

                    if (map[nx][ny].equals("P") && distance <= 2) {
                        return false;  // 거리가 2 이하이고 사람이 있으면 실패
                    } else if (map[nx][ny].equals("O") && distance < 2) {
                        q.add(new int[]{nx, ny});  // 빈 공간은 탐색 계속
                    }
                }
            }
        }

        return true;  // 조건을 모두 통과하면 true
    }
}