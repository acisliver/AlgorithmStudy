import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 고려해야할 조건
 * 1. 문자열의 구성은 대소문자와 공백이다
 * 2. 공백으로 단어를 구분하며 공백이 연속해서 나오는 경우는 없다
 * 3. 중복된 단어도 다른 단어로 본다
 * 4. 문자열이 없을 수도 있을 것이다
 */

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        // split은 매칭되는 regex가 없을 경우 자기 자신 즉 input.trim()을 반환하여 "" 빈문자열의 경우 1이 결과로 나온다
        int n = input.trim().split(" ").length;

        StringTokenizer st = new StringTokenizer(input, " ");

        System.out.println(st.countTokens());
    }
}
