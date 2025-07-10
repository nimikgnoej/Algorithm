import java.util.*;
class Solution {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public int solution(String dirs) {
        boolean [][] visited = new boolean [121][121];
        int x = 5; int y = 5;
        int answer = 0;
        for(int i = 0; i < dirs.length(); i++){
            char cmd = dirs.charAt(i);
            int nx = 0; int ny = 0;
            switch (cmd){
                case 'U': {
                    nx = x + arx[0];
                    ny = y + ary[0];
                    break;
                }   
                case 'D': {
                    nx = x + arx[1];
                    ny = y + ary[1];
                    break;
                }   
                case 'L': {
                    nx = x + arx[2];
                    ny = y + ary[2];
                    break;
                }   
                case 'R': {
                    nx = x + arx[3];
                    ny = y + ary[3];
                    break;
                } 
            }
            if(!validation(nx, ny)) continue;
            int start = x * 11 + y;
            int end   = nx * 11 + ny;
            if(!visited[start][end]){
                visited[start][end] = true;
                visited[end][start] = true;
                answer++;
            }
            x = nx;
            y = ny;   
        }
        return answer;
    }
    
    private static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx <= 10 && ny <= 10) return true;
        return false;
    }
}