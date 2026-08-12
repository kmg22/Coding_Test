import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int N = jobs.length;    // 총 작업 수
        int idx = 0;            // 다음 작업 포인터
        int currentTime=0;      // 현재 시각
        int cnt = 0;            // 처리된 작업 수
        int answer = 0;
        
        while(cnt < N){
            while((idx<N) && (jobs[idx][0]<=currentTime)){
                pq.add(jobs[idx++]);
            }
            
            if(pq.isEmpty()){
                currentTime = jobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            currentTime += job[1];
            answer += (currentTime - job[0]);
            cnt++;
        }
        
        return answer/N;
    }
}