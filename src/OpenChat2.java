import java.util.ArrayList;
import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChat2 {
    public static void main(String[] args) {
        OpenChat2 openChat = new OpenChat2();
        openChat.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();
        String[] dataList;

        for (String data : record) {
            dataList = data.split(" ");
            if (dataList[0].equals("Leave"))
                continue;
            else
                userInfo.put(dataList[1], dataList[2]);
        }

        System.out.println(userInfo);

        for (String data : record) {
            dataList = data.split(" ");
            if (dataList[0].equals("Enter"))
                answer.add(enterMsg(userInfo.get(dataList[1])));
            else if (dataList[0].equals("Leave"))
                answer.add(leaveMsg(userInfo.get(dataList[1])));
        }

        System.out.println(answer);

        return answer;
    }

    public static String enterMsg(String nickname) {
        return nickname + "님이 들어왔습니다.";
    }

    public static String leaveMsg(String nickname) {
        return nickname + "님이 나갔습니다.";
    }
}
