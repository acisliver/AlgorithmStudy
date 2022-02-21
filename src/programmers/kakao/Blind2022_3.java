package programmers.kakao;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/92341?language=java
// 주차 요금 계산
public class Blind2022_3 {
    public static void main(String[] args) {
        Blind2022_3 s = new Blind2022_3();
        System.out.println(Arrays.toString(s.solution(
                new int[]{180, 5000, 10, 600},
                new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
                )));
    }
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, Integer> timeMap = new HashMap<>();
        Set<Integer> carNumberSet = new HashSet<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String[] time = split[0].split(":");
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            int carNumber = Integer.parseInt(split[1]);
            String type = split[2];
            if (type.equals("IN")) {
                inMap.put(carNumber, 60 * hours + minutes);
                carNumberSet.add(carNumber);
            } else {
                timeMap.put(
                        carNumber,
                        timeMap.getOrDefault(carNumber, 0) + 60 * hours + minutes - inMap.get(carNumber)
                );
                carNumberSet.remove(carNumber);
            }
        }

        for (Integer carNumber : carNumberSet) {
            timeMap.put(
                    carNumber,
                    timeMap.getOrDefault(carNumber, 0) + 23 * 60 + 59 - inMap.get(carNumber)
            );
        }


        return timeMap.entrySet().stream()
                .sorted((o1, o2) -> o1.getKey() - o2.getKey())
                .map(entry -> getFee(fees, entry.getValue()))
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public int getFee(int[] fees, int minutes) {
        if (minutes <= fees[0]) {
            return fees[1];
        } else {
            return fees[1] + (int)(Math.ceil((double) (minutes - fees[0]) / fees[2])) * fees[3];
        }
    }
}
