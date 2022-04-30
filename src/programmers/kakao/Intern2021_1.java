package programmers.kakao;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/81301?language=java
// 숫자 문자열 영단어
public class Intern2021_1 {
    public static void main(String[] args) {
        Intern2021_1 s = new Intern2021_1();
        System.out.println(s.solution("one4seveneight"));
    }

    public static HashMap<String, int[]> dic = new HashMap() {{
        put("ze", new int[]{0, 2});
        put("on", new int[]{1, 1});
        put("tw", new int[]{2, 1});
        put("th", new int[]{3, 3});
        put("fo", new int[]{4, 2});
        put("fi", new int[]{5, 2});
        put("si", new int[]{6, 1});
        put("se", new int[]{7, 3});
        put("ei", new int[]{8, 3});
        put("ni", new int[]{9, 2});
    }};

    // a = 97, 1 = 49
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 96) {    // 문자라면
                String num = c + String.valueOf(s.charAt(i + 1));
                int value = dic.get(num)[0];
                i += dic.get(num)[1] + 1;
                sb.append(value);
            } else {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }


}
