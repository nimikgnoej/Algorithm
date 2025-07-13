import java.util.*;
import java.io.*;

class Solution {
    private Map<String, int[]> numbers = new HashMap<>();
    
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        fillNumberMap();
        String[] splitted = s.split("");
        int index = 0;
        while(index < splitted.length){
            if(isNumber(splitted[index])){
                sb.append(splitted[index]);
                index += 1;
            } else {
                int[] res = numbers.get(s.substring(index,index+2));
                index += res[0];
                sb.append(res[1]);
            }
        }
        return Integer.parseInt(sb.toString());
    }
    
    private void fillNumberMap() {
        numbers.put("ze",new int[]{4,0});
        numbers.put("on",new int[]{3,1});
        numbers.put("tw",new int[]{3,2});
        numbers.put("th",new int[]{5,3});
        numbers.put("fo",new int[]{4,4});
        numbers.put("fi",new int[]{4,5});
        numbers.put("si",new int[]{3,6});
        numbers.put("se",new int[]{5,7});
        numbers.put("ei",new int[]{5,8});
        numbers.put("ni",new int[]{4,9});
    }
    
    private boolean isNumber(String s) {
        if(s.charAt(0)-'0' >= 0 && s.charAt(0)-'0' <= 9) return true;
        else return false;
    }
}