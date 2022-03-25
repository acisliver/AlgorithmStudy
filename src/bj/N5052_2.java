package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.acmicpc.net/problem/5052
// 전화번호 목록
public class N5052_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            List<String> numbers = new ArrayList<>(n);

            for (int j = 0; j < n; j++) {
                numbers.add(br.readLine());
            }

            Collections.sort(numbers);

            boolean isConsistent = true;
            for (int j = 1; j < n; j++) {
                if (numbers.get(j).startsWith(numbers.get(j - 1))) {
                    isConsistent = false;
                    break;
                }
            }
            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}
