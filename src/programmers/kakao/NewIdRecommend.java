package programmers.kakao;

public class NewIdRecommend {
    public static void main(String[] args) {
        NewIdRecommend newIdRecommend = new NewIdRecommend();
        System.out.println(newIdRecommend.solution("...!@BaT#*..y.abcdefghijklm"));
    }

    public String solution(String new_id) {
        String answer = "";

        answer = new_id
                .toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");

        if (answer.length() == 0) answer += "a";

        if (answer.length() >= 16) answer = answer.substring(0, 15);

        answer = answer.replaceAll("[.]$", "");

        while(answer.length() <= 2) answer += answer.substring(answer.length() - 1, answer.length());

        return answer;
    }
}
