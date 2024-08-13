import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        if(cacheSize == 0){
            time = 5 * cities.length;
            return time;
        }

        String[] cache = new String[cacheSize];
        int[] timer = new int[cacheSize];
        for (int i = 0; i < cities.length; i++) {
            for (int k = 0; k < timer.length; k++) {
                if(timer[k] != 0)
                    timer[k]++;
            }
            String city = cities[i].toLowerCase(); // 대소문자 구분을 없애기 위해 소문자로 변환
            int isCache = contain(cache,city);
            if (isCache == -1) { // cache miss
                int idx = findIdx(timer);
                cache[idx] = city;
                timer[idx] = 1;
                // cache[i % cacheSize] = city;
                // timer[i % cacheSize] = 1;
                time += 5;
            } else { // cache hit
                time += 1;
                timer[isCache] = 1;
            }
        }
        return time;
    }

    public int contain(String[] cache, String target) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null && cache[i].equals(target)) { // cache hit
                return i;
            }
        }
        return -1; // cache miss
    }
    
    public int findZero(int[] timer){
        for(int i=0;i<timer.length;i++){
            if(timer[i] == 0)
                return i;
        }  
        return -1;
    }
    
    public int findIdx(int[] timer){
        int idx = findZero(timer);
        int maxIdx = 0;
        if(idx != -1) // has 0 in timer 
            return idx;
        else{ // has no zero in timer
            for(int i =0;i<timer.length;i++){
                if(timer[maxIdx] < timer[i])
                    maxIdx = i;
            }
            return maxIdx;
        }
    }
}