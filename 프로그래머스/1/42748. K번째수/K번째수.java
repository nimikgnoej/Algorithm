import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int x=0;x<commands.length;x++) {
            int[] command = commands[x];
            int start = command[0];
            int end = command[1];
            int target = command[2];
            
            List<Integer> temp = new ArrayList<>();
            for(int i=start-1; i<end;i++){
                temp.add(array[i]);
            }
            Collections.sort(temp);
            answer[x] = temp.get(target-1);
        }
        return answer;
    }
}