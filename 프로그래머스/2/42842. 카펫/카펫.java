class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        int sero = 0;
        int garo = 0;
        for(int i=1; i<total/2; i++) {
            if(total % i != 0) continue;
            sero = i;
            garo = total/i;
            if(checkBrownCount(sero, garo, brown))
                return new int[]{garo, sero};
        }
        return null;
    }
    
    private boolean checkBrownCount(int sero, int garo, int brown) {
        return ((garo + sero - 2) * 2) == brown;
    }
}
