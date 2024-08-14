import java.util.*;
import java.io.*;

class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> result = new ArrayList<>();
        
        s = s.replace("{","");
        String[] list = s.split("},");
        list[list.length-1] = list[list.length-1].replace("}}","");
        
        Arrays.sort(list,new Comparator<String>(){
            public int compare(String o1, String o2){
                
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for(String x : list){
            String[] temp = x.split(",");
            for(int i=0;i<temp.length;i++){
                int n = Integer.parseInt(temp[i]);
                if(!result.contains(n))
                    result.add(n);
            }
        }
        
        return result;
    }
}