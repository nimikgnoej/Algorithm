class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int mok = n / a;
            n = n - (mok * a) + (mok * b);
            answer += (mok * b);
        }
        return answer;
    }
}