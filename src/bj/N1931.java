package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1931
// 회의실 배정
public class N1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> jobList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jobList.add(new int[] {start, end});
        }

        // 종료시간이 같을 경우 시작 시간이 빠른 순으로
        jobList.sort(Comparator.comparingInt(j -> j[0]));
        jobList.sort(Comparator.comparingInt(j -> j[1]));

        int endTime = 0;
        int count = 0;
        for (int[] job : jobList) {
            if (endTime <= job[0]) {
                endTime = job[1];
                count++;
            }
        }

        System.out.println(count);

    }
}
