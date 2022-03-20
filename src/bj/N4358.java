package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/4358
// 생태학
public class N4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String species = br.readLine();
        int all = 0;
        while(true) {
            map.put(species, map.getOrDefault(species, 0) + 1);
            all++;

            species = br.readLine();
            if (species == null || species.length() == 0)
                break;
        }

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            int count = map.get(key);
            double per = (double) (count * 100) / all;

            sb.append(key).append(" ").append(String.format("%.4f", per)).append("\n");
        }

        System.out.println(sb);
    }
}
