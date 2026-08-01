import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int count = targets.length;
        int[] answer = new int[count];
        
        HashMap<Character, Integer> hsmap = new HashMap<>(); 
        for(String key : keymap){
            for(int i=0; i<key.length(); i++){
                if(hsmap.containsKey(key.charAt(i))){
                    hsmap.put(key.charAt(i), Math.min(i+1, hsmap.get(key.charAt(i))));
                }else{
                    hsmap.put(key.charAt(i), i+1);
                }
            }
        }
        
        for(int i=0; i<count; i++){
            String target = targets[i];
            int sum = 0;
            for(int j=0; j<target.length(); j++){
                if(hsmap.containsKey(target.charAt(j))){
                    sum += hsmap.get(target.charAt(j));
                }else{
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}