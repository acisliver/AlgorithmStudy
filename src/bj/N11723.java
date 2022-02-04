package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// https://www.acmicpc.net/problem/11723
// 집합
public class N11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        while(m-- > 0) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "add":
                    set.add(Integer.valueOf(command[1]));
                    break;
                case "remove":
                    set.remove(Integer.valueOf(command[1]));
                    break;
                case "check":
                    sb.append(set.contains(Integer.valueOf(command[1])) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    int value = Integer.parseInt(command[1]);
                    if (set.contains(value))
                        set.remove(value);
                    else
                        set.add(value);
                    break;
                case "all":
                    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
                    set = new HashSet<>(list);
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);
    }


}
