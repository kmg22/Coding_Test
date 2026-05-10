import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        // step1 | 대문자 -> 소문자
        String answer = new_id.toLowerCase();
        // step2 | 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 이외 문자 제거
        answer = answer.replaceAll("[^a-z0-9\\-\\_\\.]","");
        // step3 | 2번 이상 마침표 한 개 처리
        answer = answer.replaceAll("\\.{2,}",".");
        // step4 | 처음, 끝 위치 마침표 제거
        answer = answer.replaceAll("^\\.|\\.$", "");
        // step5 | 빈 문자열이라면 "a" 대입
        if(answer.isEmpty()){ answer += "a";}
        // step6 | 글자수 15자 제한(단, 마지막 마침표 안 됨)
        if(answer.length()>15){
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        // step7 | 글자수 3 이상 될때까지 마지막 문자 반복
        while(answer.length()<3){ answer += answer.charAt(answer.length()-1); }
        
        return answer;
    }
}