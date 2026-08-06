import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] networked = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(!networked[i]){
                search(i, n, computers, networked);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void search(int idx, int n, int[][] computers, boolean[] networked){
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(idx);
        networked[idx] = true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int next=0; next<n; next++){
                if(computers[curr][next]==0 || networked[next]){ continue; }
                
                q.offer(next);
                networked[next] = true;
            }
        }
    }
}