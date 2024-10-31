import java.util.*;
import java.io.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        List<Integer> b = new ArrayList<>();
        for(int i : B)
            b.add(i);
        
        Collections.sort(b, Collections.reverseOrder());
        
        for(int i=0;i<A.length;i++){
            answer += A[i] * b.get(i);
        }
        
        return answer;
    }
}