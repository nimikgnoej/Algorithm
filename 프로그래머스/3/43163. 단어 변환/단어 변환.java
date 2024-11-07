import java.util.*;
import java.io.*;

class Solution {
    
    public List<String> wordList = new ArrayList<>();
    public boolean[] isUsed;
    public List<Integer> answer = new ArrayList<>();
    public int length=0;
    
    public int solution(String begin, String target, String[] words) {
        int result=0;
        length = begin.length();
        wordList = new ArrayList<>(Arrays.asList(words));
        isUsed = new boolean[words.length];
        dfs(begin,target,wordList,0);
        if(!answer.isEmpty()){
            Collections.sort(answer);
            result = answer.get(0);   
        } else {
            result = 0;
        }
        return result;
    }
    
    public void dfs(String begin, String target, List<String> wordList,int count){
        if(begin.equals(target)){
            answer.add(count);
            return;
        }
        for(int i=0;i<wordList.size();i++){
            if(convert(begin, wordList.get(i)) && !isUsed[i]){ // 한글자 차이라서 바꿀 수 있다면
                isUsed[i] = true;
                dfs(wordList.get(i),target,wordList,count+1);
                isUsed[i] = false;
            }
        }
    }
    
    public boolean convert(String from, String to){ // from 문자열을 to로 변환 가능한지?
        int limit = 1;
        for(int i=0;i<length;i++){
            if(from.charAt(i) != to.charAt(i) && limit==1){ // 다르다면 한번까지는 ok
                limit--;
            } else if(from.charAt(i) != to.charAt(i) && limit!=1) {
                return false;
            }
        }
        if(limit == 1){ // 둘이 같은 문자열임
            return false;
        } else {
            return true;
        }
    }
}