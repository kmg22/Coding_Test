import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int answer = 0;
        int left = 1;
        int right = distance;
        
        while(left <= right){
            // 간격 최소 거리
            int mid = left + (right-left) / 2;
            
            int prev = 0;
            int removed = 0;
            
            for(int i=0; i<rocks.length; i++){
                if(rocks[i]-prev < mid){
                    removed++;
                }else{
                    prev = rocks[i];
                }
            }
            
            if(distance-prev < mid){ removed++;}
            
            if(removed <= n){
                left = mid + 1;
                answer = mid;
            }else{
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
}