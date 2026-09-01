import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int L = triangle.length;
        int[][] dp = new int[L][L];
        
        dp[0][0] = triangle[0][0];
                
        for(int step=1; step<L; step++){
            for(int i=0; i<=step; i++){
                if(i==0){ 
                    dp[step][i] += triangle[step][i] + dp[step-1][i];
                    continue;
                }
                if(i==step){
                    dp[step][i] += triangle[step][i] + dp[step-1][i-1];
                    continue;
                }
                
                dp[step][i] += triangle[step][i] + Math.max(dp[step-1][i], dp[step-1][i-1]);
            }
        }
        
        return Arrays.stream(dp[L-1]).max().getAsInt();
    }
}