import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nickname = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        // Update nickname
        for(String text : record){
            String[] log = text.split(" ");
            logs.add(log);
            switch(log[0]){
                case "Enter":
                case "Change":
                    nickname.put(log[1], log[2]);
                    break;
            }
        }
        
        List<String> answer = new ArrayList<>();
        
        // Solve the record
        for(String[] log : logs){
            switch(log[0]){
                case "Enter":
                    answer.add(nickname.get(log[1])+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    answer.add(nickname.get(log[1])+"님이 나갔습니다.");
                    break;
            }
        }
        return answer.toArray(String[]::new);
    }
}