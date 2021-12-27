import java.util.*;


//https://programmers.co.kr/learn/courses/30/lessons/60058
public class ParenthesisConvert {
    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
    }


    public static String solution(String p) {

        return recursive(p);
    }

    // 재귀적으로 문자열 나누기
    public static String recursive(String p) {

        // 1. 빈 문자열이면
        if (p.length() == 0) return p;

        // 2.균형잡힌 문자열로 나눔
        String u = p.substring(0, getUIndex(p));
        String v = p.substring(getUIndex(p));

        // 3.
        // u가 올바른 문자열인가?
        // v에 대해 getUIndex 재귀적으로 적용
        if (isRight(u)) {
            return u + recursive(v);
        }
        // 4. v에 대해 재귀적으로 실행 후
        // ( + v + ) + u에 대한 처리
        else {
            v = recursive(v);
            return makeRight(u, v);
        }
    }


    // 균형잡힌 문자열로 반환
    public static int getUIndex(String p) {

        int open = 0;
        int close = 0;
        int idx = 0;

        for (String s : p.split("")) {
            idx++;
            if (s.equals("(")) open++;
            else close++;
            if (open == close)
                return idx;
        }

        return 0;
    }

    // 올바른 문자열인지 확인
    public static boolean isRight(String u) {

        Queue<String> queue = new LinkedList<>(Arrays.asList(u.split("")));

        Stack<String> stack = new Stack<>();

        while(!queue.isEmpty()) {
            if (queue.peek().equals("("))
                stack.push(queue.poll());
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
                queue.poll();
            }
        }
        return true;

    }

    // 균형잡힌 문자열을 올바른 문자열로 변환
    public static String makeRight(String u, String v) {

        // 처음과 마지막 괄호 제거
        String[] newU = u.substring(1, u.length() - 1).split("");

        // 괄호 반전
        for (int i = 0; i < newU.length; i++) {
            if (newU[i].equals("(")) newU[i] = ")";
            else if(newU[i].equals(")")) newU[i] = "(";
        }

        return "(" + v + ")" + String.join("", newU);
    }
}
