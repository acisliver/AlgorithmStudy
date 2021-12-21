package programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChat2 {
    public static void main(String[] args) {
        OpenChat2 openChat = new OpenChat2();
        openChat.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 ";

    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();
        String[] dataList;

        // uid, nickname 매칭
        for (String data : record) {
            dataList = data.split(" ");
            if (dataList[0].equals("Leave"))
                continue;
            else
                userInfo.put(dataList[1], dataList[2]);
        }

        System.out.println(userInfo);

        // 출력문 작성
        for (String data : record) {
            dataList = data.split(" ");
            if (dataList[0].equals("Enter"))
                answer.add(String.format(ENTER_FORMAT, userInfo.get(dataList[1])));
            else if (dataList[0].equals("Leave"))
                answer.add(String.format(LEAVE_FORMAT, userInfo.get(dataList[1])));
        }

        System.out.println(answer);

        return answer.stream()
                .toArray(array -> new String[answer.size()]);
    }
}
