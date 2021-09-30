import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class KeyLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            getPassword(br.readLine());
        }
    }

    private static void getPassword(String log) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < log.length(); i++){
            switch (log.charAt(i)) {
                case '<':
                    if (!stack1.empty()) stack2.push(stack1.pop());
                    break;
                case '>':
                    if (!stack2.empty()) stack1.push(stack2.pop());
                    break;
                case '-':
                    if (!stack1.empty()) stack1.pop();
                    break;
                default:
                    stack1.push(log.charAt(i));
                    break;
            }
        }

        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack1.size(); i++){
            sb.append(stack1.elementAt(i));
        }
        System.out.println(sb);

//        stack1.forEach(System.out::print);
    }
}
