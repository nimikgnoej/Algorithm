import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        int[][] dp = new int[size][size];
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1;i<size;i++){
            for(int j=0;j<=i;j++){
                if(j-1>=0)
                    if(i==j)
                        dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                else if(j-1<0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
            }
        }
        int biggest = 0;
        for(int i=0;i<size;i++){
            if(dp[size-1][i] > biggest)
                biggest = dp[size-1][i];
        }
        answer = biggest;
        
        return answer;
    }
}