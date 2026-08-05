import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int mixCnt=0;
        
        for(int x : scoville){
            pq.offer(x);
        }
        
        while(pq.size()>=2 && pq.peek()<K){
            int x1 = pq.poll();
            int x2 = pq.poll();
            pq.offer(x1 + x2*2);
            mixCnt++;
        }
        
        return pq.peek()>=K ? mixCnt : -1;
    }
}