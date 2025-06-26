import java.util.*;
import java.io.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int x = arr1.length;
        int mid = arr1[0].length;
        int y = arr2[0].length;
        System.out.println(x+ " " +y);
        
        int[][] answer = new int[x][y];
        for (int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                int temp = 0;
                for(int k=0;k<mid;k++){
                    temp += (arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = temp;
            }
        }
        
        return answer;
    }
}