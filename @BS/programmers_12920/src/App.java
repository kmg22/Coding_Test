import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int coreN = cores.length;
        
        if(n <= coreN){ return n; }
        
        long left = 0;
        long right = (long) n * Arrays.stream(cores).min().getAsInt();
        long time = 0;       // 마지막 작업 시작 시각
        
        while(left <= right){
            long mid = left + (right - left) / 2;
            
            long jobs = coreN;
            for(int core : cores){
                jobs += mid / core;
                
                if(jobs >= n){ break; }
            }
            
            if(jobs >= n){
                right = mid - 1;
                time = mid;
            }else{
                left = mid + 1;
            }
        }
        
        long prevTime = time - 1;   // 마지막 작업 시작 시각 - 1
        long cnt = coreN;            
        
        // prevTime까지 시작한 작업 개수
        for(int core : cores){
            cnt += prevTime / core;
        }
        
        for(int i=0; i<coreN; i++){
            if(time%cores[i] == 0){ 
                cnt++; 
                
                if(cnt == n){
                    return i+1;
                }
            }      
        }
        return -1;
    }
}