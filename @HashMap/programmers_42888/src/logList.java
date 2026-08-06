
import java.util.*;

class Solution {
    // log 전용 클래스
    static class Log {
        String command;
        String uid;
        String nickname;

        public Log(String command, String uid, String nickname) {
            this.command = command;
            this.uid = uid;
            this.nickname = nickname;
        }
    }

    public String[] solution(String[] record) {

        List<Log> logs = new ArrayList<>();
        Map<String, String> nicknameMap = new HashMap<>();

        // 1. 로그 파싱 + 최종 닉네임 갱신
        for (String recordLog : record) {
            String[] token = recordLog.split(" ");

            String command = token[0];
            String uid = token[1];
            String nickname = token.length == 3 ? token[2] : null;

            Log log = new Log(command, uid, nickname);
            logs.add(log);

            if (!command.equals("Leave")) {
                nicknameMap.put(uid, nickname);
            }
        }

        // 2. 최종 닉네임으로 메시지 생성
        List<String> answer = new ArrayList<>();

        for (Log log : logs) {

            if (log.command.equals("Enter")) {
                answer.add(nicknameMap.get(log.uid) + "님이 들어왔습니다.");
            } else if (log.command.equals("Leave")) {
                answer.add(nicknameMap.get(log.uid) + "님이 나갔습니다.");
            }

        }

        return answer.toArray(new String[0]);
    }
}