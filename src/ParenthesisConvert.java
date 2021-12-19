import java.util.*;

public class ParenthesisConvert {
    public static void main(String[] args) {

        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {

        if (p.length() == 0) return p;

        StringBuilder answer = new StringBuilder();

        String u = p.substring(0, getUIndex(p));
        String v = p.substring(getUIndex(p));

        if (isRight(u)) {
            u = v.substring(0, getUIndex(v));
            v = v.substring(getUIndex(v));
        }

        while(v.length() != 0){

            u = u.substring(0, getUIndex(u));
            v = u.substring(getUIndex(u));
        }

        return u;
    }


    // 균형잡힌 문자열로 변환
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
}
