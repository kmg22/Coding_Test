import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++){
            int days = (100-progresses[i]+speeds[i]-1) / speeds[i];
            q.offer(days);
        }
        
        while(!q.isEmpty()){
            int cnt = 1;
            int top = q.poll();
            while(!q.isEmpty() && top>=q.peek()){
                q.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}