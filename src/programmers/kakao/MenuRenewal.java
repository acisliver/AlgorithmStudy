package programmers.kakao;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
    }

    public static String[] solution(String[] orders, int[] course) {

        // 1. 가능한 메뉴 조합 생성
        // 해시맵에 저장 K: 조합, V: 빈도
        HashMap<String, Integer> combi = getCombinationMap(orders, course);

        // 2. V가 2 이상인 K 리턴
        // 단, 알파벳 순서로 정렬

        HashMap<String, Integer> hashMap = makeHashMap(orders);

        System.out.println(hashMap.toString());

        // 해시맵 내림차순으로 정렬
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println(entryList);

        return getResult(entryList, course);
    }

    private static HashMap<String, Integer> getCombinationMap(String[] orders, int[] course) {

        boolean[] visited;
        HashMap<String, Integer> combi = new HashMap<>();

        for (String order : orders) {
            visited = new boolean[order.length()];
            int start = 0;
            for (Integer n : course) {
                for (int i = start; i < n; i++) {


                }
            }
        }


        for (Integer start : course) {
            for (int i = start; i < orders.length; i++) {
                String order = orders[i];

            }
        }

        return null;
    }

    private static void setCombinationMap(){}

    // orders의 특정 메뉴가 얼마나 나왔는지 세고 해시맵에 저장
    private static HashMap<String, Integer> makeHashMap(String[] orders) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> list;

        for (String order : orders) {
            list = Arrays.asList(order.split(""));
            for (String o : list) {
                if (!hashMap.containsKey(o)) hashMap.put(o, 1);
                else {
                    hashMap.put(o, hashMap.get(o) + 1);
                }
            }
        }

        return hashMap;
    }

    private static String[] getResult(List<Map.Entry<String, Integer>> entryList, int[] course) {


        for (Integer n : course) {

        }

        return new String[10];
    }
}
