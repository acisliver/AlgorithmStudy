import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SortingGame2 {
    public static void main(String[] args) throws IOException {
        Vector<Integer> perm = new Vector<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int textCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < textCase; i++) {
            int arrayLength = Integer.parseInt(br.readLine());
            String arrays = br.readLine();
            StringTokenizer st = new StringTokenizer(arrays, " ");
            for (int j = 0; j < arrayLength; j++) {
                perm.add(Integer.parseInt(st.nextToken()));
            }
            int output = bfs(perm);
            System.out.println(output);
            perm.clear();
        }

    }


    static int bfs(Vector<Integer> perm) {
        int n = perm.size();
        Vector<Integer> sorted = new Vector<>(perm);
        Collections.sort(sorted);
        Queue<Vector<Integer>> q = new LinkedList<>();
        Map<Vector<Integer>, Integer> distance = new HashMap<>();
        distance.put(perm, 0);
        q.add(perm);
        Vector<Integer> themVector;
        while (!q.isEmpty()) {
            Vector<Integer> here = q.poll();
            if (here.equals(sorted)) {
                return distance.get(here);
            }
            int cost = distance.get(here);
            for (int i = 0; i < n; i++) {
                for (int j = i + 2; j <= n; j++) {
                    System.out.println("안뒤집은 데이터:"+here);
                    Collections.reverse(here.subList(i, j));
                    if (distance.get(here) == null) {
                        themVector = new Vector<>(here);
                        distance.put(themVector, cost + 1);
                        q.offer(themVector);
                        int tem=cost+1;
                        System.out.println("here:" + here + " cost:" +tem);
                    }
                    Collections.reverse(here.subList(i, j));
                }
            }
        }
        return -1;
    }
}