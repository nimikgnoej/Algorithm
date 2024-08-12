class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(true){
            if(a==b)
                break;
            
            a = a/2 + a%2;
            b = b/2 + b%2;
            answer++;
        }

        return answer;
    }
    
    public boolean check(int a, int b){
        if(a>b){
            if(a-b==1)
                return true;
            else return false;
        } else {
            if(b-a==1)
                return true;
            else return false;
        }
    }
}