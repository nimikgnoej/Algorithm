import java.util.*;
import java.io.*;

class Solution {
    private int basicTime = 0;
    private int basicPrice = 0;
    private int unitTime = 0;
    private int unitPrice = 0;
    
    private Map<String, Integer> result = new HashMap<>();
    private Map<String, String> inAndOut = new HashMap<>();
    private List<Integer> answer = new ArrayList<>();
    
    public List<Integer> solution(int[] fees, String[] records) {
        basicTime = fees[0];
        basicPrice = fees[1];
        unitTime = fees[2];
        unitPrice = fees[3];
        
        for(String record : records) {
            String[] data = record.split(" ");
            String carNumber = data[1];
            String time = data[0];
            String isIn = data[2];
            
            if("IN".equals(isIn)) {
                inAndOut.put(carNumber, time);
            } else {
                String startTime = inAndOut.get(carNumber);
                inAndOut.remove(carNumber);
                int duration = convertHourToMinute(time) - convertHourToMinute(startTime);
                
                if(result.containsKey(carNumber)) {
                    int exist = result.get(carNumber);
                    result.put(carNumber, exist + duration);
                } else
                    result.put(carNumber, duration);
            }
        }
        List<String> keySet = new ArrayList<>(inAndOut.keySet());
        for(String key : keySet) {
            int duration = convertHourToMinute("23:59") - convertHourToMinute(inAndOut.get(key));
            if(result.containsKey(key)){
                int exist = result.get(key);
                result.put(key, exist + duration);
            } else
                result.put(key, duration);
        }
        
        for(Map.Entry<String,Integer> entrySet : result.entrySet()){
            String carNum = entrySet.getKey();
            int finalDuration = entrySet.getValue();
            if(finalDuration >= basicTime) {
                int money = basicPrice + (int) Math.ceil((double)(finalDuration - basicTime) / unitTime) * unitPrice;
            
                result.put(carNum, money);
            } else {
                result.put(carNum, basicPrice);
            }
        }
        List<String> temp = new ArrayList<>(result.keySet());
        Collections.sort(temp);
        for(String key : temp){
            answer.add(result.get(key));
        }
        return answer;
    }
    
    private int convertHourToMinute(String time) { // 07:10
        String[] timeList = time.split(":");
        String hour = timeList[0];
        String minute = timeList[1];
        
        if(hour.startsWith("0")){
            hour = hour.substring(1,2);
        }
        
        if(minute.startsWith("0")){
            minute = minute.substring(1,2);
        }
        
        return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
    }
}