import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // 조건1
        for(int i=1; i<arrayA.length; i++){
            gcdA = getGCD(gcdA, arrayA[i]);
            if(gcdA == 1){ break; }
        }
        
        for(int i=0; i<arrayB.length; i++){
            if((arrayB[i] >= gcdA) && (arrayB[i]%gcdA == 0)){
                gcdA = 0;
                break;
            }
        }
        
        // 조건2
        for(int i=1; i<arrayB.length; i++){
            gcdB = getGCD(gcdB, arrayB[i]);
            if(gcdB == 1){ break; }
        }
        
        for(int i=0; i<arrayA.length; i++){
            if((arrayA[i] >= gcdB) && (arrayA[i]%gcdB == 0)){
                gcdB = 0;
                break;
            }
        }
                
        return Math.max(gcdA, gcdB);
    }
    
    private int getGCD(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
}