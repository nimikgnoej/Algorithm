import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        
        for(String name : participant){
            hash.put(name, hash.getOrDefault(name,0) + 1);
        }
        
        for(String name : completion){
            hash.put(name, hash.get(name) -1);
        }
        
        for(String s : hash.keySet()){
            if(hash.get(s)!=0)
                answer = s;
        }
        return answer;
    }
}