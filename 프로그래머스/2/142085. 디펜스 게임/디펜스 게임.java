import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int len = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int card =0;
        int i;
        for(i=0;i<len;i++){
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n<0){
                if(k>0){
                    card = pq.poll();
                    n+=card;
                    k--;
                } else {
                    break;
                }
            }
        }
        answer = i;
     
        return answer;
    }
}