import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> hs = new HashSet<>();
        
        for(String number : phone_book){
            hs.add(number);
        }
        
        for(String number : phone_book){
            for(int i=1; i<number.length(); i++){
                if(hs.contains(number.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}