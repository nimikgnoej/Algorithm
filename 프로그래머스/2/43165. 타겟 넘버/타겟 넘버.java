class Solution {
    int tar=0;
    int count=0;
    
    public int solution(int[] numbers, int target) {
        tar = target;
        
        dfs(0,0,numbers);
        
        return count;
    }
    
    public void dfs(int sum, int order, int[] numbers){
        if(order == numbers.length){
            if(sum==tar)
                count++;
            return;
        }
        dfs(sum+numbers[order], order+1, numbers);
        dfs(sum-numbers[order], order+1, numbers);
    }
}