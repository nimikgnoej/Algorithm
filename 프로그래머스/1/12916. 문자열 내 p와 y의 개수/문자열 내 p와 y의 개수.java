class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt=0;
        int yCnt=0;
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p')
                pCnt++;
            else if(s.charAt(i)=='y')
                yCnt++;
        }

        if(pCnt==yCnt){
            answer = true;
        } else
            answer=false;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}