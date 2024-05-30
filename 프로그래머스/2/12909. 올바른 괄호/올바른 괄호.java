import java.util.*;

class Solution {
    public static boolean answer = true;
    boolean solution(String s) {
        sol(s);
        return answer;
    }
    
    void sol(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            } else {
                if(!stack.isEmpty()){
                    if(stack.peek()=='(')
                        stack.pop();   
                }
                else{
                    answer = false;
                    return;
                }
            }
        }
        if(!stack.isEmpty())
            answer=false;
    }
}