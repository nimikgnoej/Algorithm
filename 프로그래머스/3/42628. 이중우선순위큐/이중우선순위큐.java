import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        
        for(String operation : operations){
            String[] input = operation.split(" ");
            String op = input[0];
            int number = Integer.parseInt(input[1]);
            
            if("I".equals(op)){
                pq.add(number);
                reverse.add(number);
            } else if("D".equals(op)){
                if(!pq.isEmpty()){
                    if(number==1){ // 최댓값 삭제
                        int target = reverse.poll();
                        pq.remove(target);
                    } else {
                        int target = pq.poll();
                        reverse.remove(target);
                    }
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        if(pq.isEmpty()){
            answer.add(0);
            answer.add(0);
        } else {
            answer.add(reverse.poll());
            answer.add(pq.poll());
        }
        return answer;
    }
}