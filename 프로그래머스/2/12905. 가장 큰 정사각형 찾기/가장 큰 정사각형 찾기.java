import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int[][] map)
    {
        int garoSize = map[0].length;
        int seroSize = map.length;
        int answer=0;
        
        if(garoSize<2 || seroSize<2){
            return 1;
        }
        
        for(int i=1;i<seroSize;i++){
            for(int j=1;j<garoSize;j++){
                if(map[i][j]!=1) continue;
                map[i][j] = Math.min(Math.min(map[i][j-1],map[i-1][j]),map[i-1][j-1])+1;
                if(answer < map[i][j]) answer = map[i][j];
            }
        }

        return answer*answer;
    }
}