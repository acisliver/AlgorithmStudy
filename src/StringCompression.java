import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/60057
class StringCompression {

    public int solution(String s) {
        int answer = 0;

        int counter = 1;

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int subLen = s.length() / 2;
        for (int i = 2; i < subLen; i++) {

            // i 크기로 s 자르기
            int j;
            for (j = 0; j < s.length() / i; j++) {
                list.add(s.substring(i * j, i * (j + 1)));
            }

            // 길이가 i 보다 작은 마지막 남은 s 출력
            if (i * j < s.length())
                list.add(s.substring(i * j));

            // 연속되는 패턴 찾기
            for (int p = 0; p < list.size() - 1; p++) {
                if (list.get(p).equals(list.get(p + 1)))
                    counter++;
                else if (counter > 1) {
                    sb.append(counter);
                    sb.append(list.get(p - 1));
                    counter = 0;
                }
                else
                    sb.append(list.get(p));
            }

            if (counter > 1) {
                sb.append(counter);

            }

            System.out.println(Arrays.toString(list.toArray()));
            System.out.println(sb);
            sb = new StringBuilder();
            list = new ArrayList<>();
        }

        return answer;
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        s.solution("abcabcabcabcdededededede");
    }
}