import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int N = words.length;
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr.word.equals(target)){ return curr.cnt; }
            
            for(int i=0; i<N; i++){
                if(visited[i]){ continue; }
                if(!isNeighbor(curr.word, words[i])){ continue; }
                
                visited[i] = true;
                q.offer(new Node(words[i], curr.cnt+1));
            }
        }
        
        return 0;
    }
    
    private boolean isNeighbor(String word1, String word2){
        int diff=0;
        for(int i=0; i<word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){ diff++; }
            if(diff>1){ return false; }
        }
        return diff==1;
    }
    
    
    static class Node{
        String word;
        int cnt;
        
        Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
}