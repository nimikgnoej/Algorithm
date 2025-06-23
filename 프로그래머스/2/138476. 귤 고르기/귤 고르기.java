import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            if(!map.containsKey(t)){
                map.put(t,1);
            } else {
                map.replace(t,map.get(t)+1);
            }
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((e1, e2) -> map.get(e2) - map.get(e1));
        
        for(int key : keySet){
            if(k<=0) break;
            k -= map.get(key);
            answer += 1;
        }
    
        return answer;
    }
}