import java.util.ArrayList;
import java.util.Arrays;

public class OpenChat {
    public static void main(String[] args) {
        OpenChat openChat = new OpenChat();
        openChat.solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
    }

    public ArrayList<String> solution(String[] record) {

        ArrayList<String> answer = new ArrayList<>();
        String uid;
        for (int i = 0; i < record.length; i++) {
            // 닉네임 변경 이벤트 발생
            if (record[i].split(" ")[0].equals("Change")) {
                uid = record[i].split(" ")[1];
                updateRecord(record, uid, record[i].split(" ")[2], i);
            }
            else if (record[i].split(" ")[0].equals("Enter")) {
                uid = record[i].split(" ")[1];
                updateRecord(record, uid, record[i].split(" ")[2], i);
            }

        }

        for (int i = 0; i < record.length; i++) {
            if (record[i].split(" ")[0].equals("Enter")) {
                answer.add(enterMsg(record[i].split(" ")[2]));
            }
            else if (record[i].split(" ")[0].equals("Leave")) {
                answer.add(leaveMsg(record, record[i].split(" ")[1]));
            }
        }

        System.out.println(Arrays.toString(record));
        System.out.println(answer);

        for (String data : record) {

        }

        return answer;
    }

    // record에서 매칭되는 uid를 찾아 닉네임 변경
    private void updateRecord(String[] record, String uid, String newNickName, int end) {
        for (int i = 0; i < end; i++) {
            String[] data = record[i].split(" ");
            if (data[1].equals(uid)) {
                if (data[0].equals("Leave")) break;
                data[2] = newNickName;
                record[i] = String.join(" ", data);
            }
        }
    }

    public static String enterMsg(String nickname) {
        return nickname + "님이 들어왔습니다.";
    }

    public static String leaveMsg(String[] record, String uid) {
        String nickname = "";
        for (String data : record) {
            if (data.split(" ")[1].equals(uid)) {
                if (data.split(" ")[0].equals("Leave")) break;
                nickname = data.split(" ")[2];
            }
        }

        return nickname + "님이 나갔습니다.";
    }
}
