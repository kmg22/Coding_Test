import java.util.*;

class Solution {
    public long solution(int n, int[] times) {        
        long answer = 0;
        long left = 0;
        long right = (long) n * Arrays.stream(times).max().getAsInt();
        
        while(left<=right){
            long mid = left + (right-left) / 2;
            
            // 주어진 mid 시간 동안 심사관의 최대 처리 인원
            long cnt=0;
            for(int time : times){
                cnt += (mid / time);
            }
            
            if(cnt >= n){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        
        return answer;
        
        
    }
}