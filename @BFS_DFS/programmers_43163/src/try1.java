import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int N = words.length;
        int MAX = N+1;
        int answer = MAX;
        
        int[] dist = new int[N]; // words[i] <-> target 최단 거리
        Arrays.fill(dist, MAX);
        
        List<Integer>[] neighbors = new ArrayList[N];
        for(int i=0; i<N; i++){ neighbors[i] = new ArrayList<>(); }
        
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                if(isNeighbor(words[i], words[j])){
                    neighbors[i].add(j);
                    neighbors[j].add(i);
                }
            }
        }
        
        boolean flag = true;
        for(int i=0; i<N; i++){
            if(words[i].equals(target)){
                calc(i, neighbors, dist);
                flag = false;
            }
        }
        // words에 target 존재 x
        if(flag){ return 0; }
        
        for(int i=0; i<N; i++){
            if(isNeighbor(begin, words[i])){
                answer = Math.min(answer, dist[i]+1);
            }
        }
        return answer>=MAX?0:answer;
    }
    
    private boolean isNeighbor(String word1, String word2){
        int diff=0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){ diff++; }
            if(diff>1){ return false; }
        }
        return diff==1;
    }
    
    private void calc(int target, List<Integer>[] neighbors, int[] dist){
        Queue<int[]> q = new ArrayDeque<>();
        
        dist[target] = 0;
        q.offer(new int[] {target, 0});
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currN = curr[0];
            int currD = curr[1];
            
            if(currD > dist[currN]){ continue; }
            
            for(int nextN : neighbors[currN]){
                if(dist[nextN] > currD+1){
                    dist[nextN] = currD+1;
                    q.offer(new int[] {nextN, dist[nextN]});
                }
            }
        }
    }
}