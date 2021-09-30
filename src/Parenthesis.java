import java.util.Scanner;
import java.util.Stack;

/**
 * ps는 '('와 ')'로 이루어진 문자열
 * 단순괄호문제
 * 스택은 구현안하겠다
 */
public class Parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String ps;
        for(int i = 0; i < n; i++){
            ps = sc.nextLine();
            System.out.println(VPS(ps) ? "YES" : "NO");
        }
    }

    static boolean VPS(String ps){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < ps.length(); i++){
            if(ps.charAt(i) == '(')
                stack.push('(');
            else {
                if (!stack.empty()) stack.pop();
                else return false;
            }
        }

        return stack.empty();
    }
}
