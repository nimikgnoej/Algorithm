import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        String[] inputs = s.split(" ");
        List<Integer> numbers = new ArrayList<>();
        
        for(String input : inputs){
            numbers.add(Integer.parseInt(input));
        }
        Collections.sort(numbers);
        
        sb.append(numbers.get(0)).append(" ").append(numbers.get(numbers.size()-1));
        answer = sb.toString();
        return answer;
    }
}