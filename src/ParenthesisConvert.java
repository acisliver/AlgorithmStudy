import java.util.*;

public class ParenthesisConvert {
    public static void main(String[] args) {

        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {

        if (p.length() == 0) return p;

        String u = getU(p);

        if (u.length() == p.length()) return u;

        String v = p.substring(u.length());
        u = getU(v);

        return u;
    }

    public static String getU(String p) {

        Queue<String> queue = new LinkedList<>(Arrays.asList(p.split("")));

        Stack<String> stack = new Stack<>();

        Queue<String> u = new LinkedList<>();

        while(!queue.isEmpty()) {
            if (queue.peek().equals("("))
                stack.push(queue.poll());
            else {
                if (stack.isEmpty()) return String.join("", u);
                u.add(stack.pop());
                u.add(queue.poll());
            }
        }
        return String.join("", u);

    }
}
