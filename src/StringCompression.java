import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/60057
class StringCompression {

    public int solution(String s) {
        int answer = s.length();

        List<String> list = new ArrayList<>();

        // 반 이상 자를 필요 X
        int subLen = s.length() / 2;
        for (int i = 1; i < subLen + 1; i++) {

            // i 크기로 s 자르기
            int j;
            for (j = 0; j < s.length() / i; j++) {
                list.add(s.substring(i * j, i * (j + 1)));
            }
            System.out.println(Arrays.toString(list.toArray()));

            // 길이가 i 보다 작은 마지막 남은 s 출력
            if (i * j < s.length())
                list.add(s.substring(i * j));
            // 종점
            list.add("");

            // 연속되는 패턴 찾기
            // 최소값 측정
            answer = Math.min(answer, getPattern(list).length());

            // 초기화
            list = new ArrayList<>();
        }

        return answer;
    }


    // 연속되는 패턴 찾기
    public static String getPattern(List<String> subStringList) {

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (String subString : subStringList) {

            // 스택이 비어있다면 푸쉬
            if (stack.isEmpty()) stack.push(subString);

            // 스택이 비어있지 않다면
            else {
                // 스택에 있는 문자열이 푸쉬할 문자열과 같을 때 푸쉬
                if (stack.peek().equals(subString)) stack.push(subString);

                // 스택에 있는 문자열이 푸쉬할 문자열과 다를 때
                // 스택을 모두 비운다.
                else{
                    if (stack.size() > 1) sb.append(stack.size());
                    sb.append(stack.pop());
                    while (!stack.isEmpty()) {
                        stack.pop();
                    }
                    stack.push(subString);
                }
            }
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.solution("aabbaccc"));
    }
}