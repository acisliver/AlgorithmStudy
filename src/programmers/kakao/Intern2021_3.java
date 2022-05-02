package programmers.kakao;

import java.util.LinkedList;
import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/81303?language=java
// 표 편집
public class Intern2021_3 {
    public static void main(String[] args) {
        Intern2021_3 s = new Intern2021_3();
        System.out.println(s.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    public String solution(int n, int k, String[] cmd) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        Stack<int[]> stack = new Stack<>();
        int cursor = k;

        for (String s : cmd) {
            if (s.length() == 1) {
                if (s.equals("C")) {
                    int where = list.indexOf(list.get(cursor));
                    stack.push(new int[]{list.remove(cursor), where});
                    if (list.size() == cursor) {
                        cursor--;
                    }
                } else {
                    int[] el = stack.pop();
                    if (el[1] == list.size()) {
                        list.add(el[0]);
                    } else {
                        list.add(el[1], el[0]);
                    }
                    if (cursor > el[1]) {
                        cursor++;
                    }
                }

            } else {
                String c = s.split(" ")[0];
                int index = Integer.parseInt(s.split(" ")[1]);

                if (c.equals("U")) {
                    cursor -= index;
                } else {
                    cursor += index;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i == list.get(j)) {
                answer.append("O");
                j++;
            } else {
                answer.append("X");
            }
        }


        return answer.toString();
    }

}
