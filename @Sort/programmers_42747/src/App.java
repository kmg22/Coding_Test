import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;

        int low=1;
        int high=n;
        
        Arrays.sort(citations);
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(citations[n-mid] >= mid){
                answer = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return answer;
    }
}