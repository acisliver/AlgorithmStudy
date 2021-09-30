import java.util.Scanner;
import java.util.Stack;

public class MidToPostfix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(Postfix(sc.nextLine()));
    }

    static int priority(Character operator){
        switch (operator) {
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return -1;
    }

    static String Postfix(String mid) {
        Stack stack = new Stack();
        StringBuffer post = new StringBuffer("");

        for (int i = 0; i < mid.length(); i++){

        }
        return "";
    }
}
