package bj;

import java.util.*;

// https://www.acmicpc.net/problem/2751
// 수 정렬하기 2
public class N2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        for (Integer num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
