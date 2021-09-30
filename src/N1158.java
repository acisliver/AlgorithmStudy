import java.util.*;

/**
 * 요세푸스 문제
 * 입력: {인원} n, {몇번째} k
 * 원형으로 n명 중 k번째 사람을 빼서 수열을 만든다
 * 원형큐와 스택(문자열) 활용
 */
public class N1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Josephus(n, k);
    }

    private static void Josephus(int n, int k) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        // 큐 초기화
        for (int i = 1; i < (n + 1); i++){
            queue.add(i + "");
        }


        // k-1번 큐를 원형으로 이동 시키고
        // k번째 요소를 스택에 담아 수열을 완성시킨다
        while(!queue.isEmpty()){
            for (int i = 0; i < (k - 1); i++){
                queue.add(queue.remove());
            }
            stack.push(queue.remove());
        }

        // Stack to Array(String)
        String[] arr = stack.toArray(new String[0]);

        // StringJoiner클래스
        // 앞뒤로 <> 붙이고 구분자로 , 사용
        StringJoiner sj = new StringJoiner(", ", "<", ">");

        // sj에 수열을 넣어준다
        for (String s : arr)
            sj.add(s);

        // sj 프린트
        System.out.println(sj.toString());
    }
}
