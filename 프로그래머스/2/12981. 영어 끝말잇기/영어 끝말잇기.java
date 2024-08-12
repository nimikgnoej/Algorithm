import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int n, String[] words) {
        List<Integer> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(words[0]);

        int headCnt = 1;
        int count = 1;
        int lastIndex = words[0].length()-1;

        for(int i=1;i<words.length;i++){
            if(temp.contains(words[i])){
                answer.add(i % n + 1);
                count = i/n + 1;
                answer.add(count);
                break;
            }
        
            if(words[i].charAt(0) != words[i-1].charAt(lastIndex)){
                // 다르면 i번째 사람 탈락
                answer.add(i % n + 1);
                count = i/n + 1;
                answer.add(count);
                break;
            } 
            lastIndex = words[i].length()-1;
            temp.add(words[i]);
        }
        if(answer.size()==0){
            answer.add(0);
            answer.add(0);
        }
        return answer;
    }
}