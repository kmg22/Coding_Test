import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> idxQ = new ArrayDeque<>();
        PriorityQueue<Integer> priQ = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            idxQ.offer(i);
            priQ.offer(priorities[i]);
        }
        
        int order = 0;
        
        while(!idxQ.isEmpty()){
            int x = idxQ.poll();
            
            if(priorities[x] == priQ.peek()){
                priQ.poll();
                order++;
                
                if(x == location){
                    return order;
                }
            }else{
                idxQ.offer(x);
            }
            
        }
        return -1;
    }
}