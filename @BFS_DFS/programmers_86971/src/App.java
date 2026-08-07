import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<Integer>[] edges = new ArrayList[n];
        for(int i=0; i<n; i++){ edges[i] = new ArrayList<>(); }
        
        for(int[] wire : wires){
            int n1 = wire[0]-1;
            int n2 = wire[1]-1;
            
            edges[n1].add(n2);
            edges[n2].add(n1);
        }
        
        for(int[] wire : wires){
            int x1 = wire[0]-1;
            int x2 = wire[1]-1;
            
            int cnt1 = search(x1, x2, x1, n, edges);
            int cnt2 = n-cnt1;
            
            answer = Math.min(answer, Math.abs(cnt1-cnt2));
        }
        return answer;
    }
    
    private int search(int x1, int x2, int start, int n, List<Integer>[] edges){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        
        int size = 1;
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int next : edges[curr]){
                if((curr==x1&&next==x2) || (curr==x2&&next==x1)){ continue; }
                if(visited[next]){ continue; }
                
                q.offer(next);
                visited[next] = true;
                size++;
            }
        }
        return size;
    }                         
}