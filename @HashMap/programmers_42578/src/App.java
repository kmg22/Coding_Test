import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesCnt = new HashMap<>();
        for(String[] piece : clothes){
            clothesCnt.put(piece[1], clothesCnt.getOrDefault(piece[1],0)+1);
        }
        
        int answer = 1;
        for(int cnt : clothesCnt.values()){
            answer *= (cnt+1);
        }
        
        return answer-1;
    }
}