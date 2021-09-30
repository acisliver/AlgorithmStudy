import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class N2638 {
    private static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cheese = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 내부(0), 외부(2) 공기 구분
        deleteExternalAir(cheese, 0, 0);

        while (isCheese(cheese)) {

            ArrayList<int[]> outCheeseIndex = getMeltingCheese(cheese);
            time++;
            meltCheese(cheese, outCheeseIndex);
            for (int i = 0; i < cheese.length; i++) {
                for (int j = 0; j < cheese.length; j++) {
                    if (cheese[i][j] == 0) {
                        for (int k = -1; k < 2; k++) {
                            for (int l = -1; l < 2; l++) {
                                try {
                                    if (k * l == 0 && cheese[i + k][j + l] == 2)
                                        deleteExternalAir(cheese, i + k, j + l);
                                } catch (ArrayIndexOutOfBoundsException ignored) {
                                }
                            }

                        }

                    }

                }
            }
        }

        System.out.println(time);
    }

    // 외부 공기는 2로 표현
    private static void deleteExternalAir(int[][] cheese, int i, int j) {
        cheese[i][j] = 2;

        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                try {
                    if (k * l == 0 && cheese[i + k][j + l] == 0)
                        deleteExternalAir(cheese, i + k, j + l);
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }

        }
    }

    // 치즈 녹이기(1 -> 0) 한 번에 녹여야함
    private static void meltCheese(int[][] cheese, ArrayList<int[]> outCheeseIndex) {
        for (int[] cheeseIndex : outCheeseIndex) {
            cheese[cheeseIndex[0]][cheeseIndex[1]] = 2;
        }
    }

    // 1시간 뒤 녹을 치즈의 위치 탐색
    private static ArrayList<int[]> getMeltingCheese(int[][] cheese) {
        ArrayList<int[]> outCheeseIndex = new ArrayList<>();

        for (int i = 1; i < (cheese.length - 1); i++) {
            for (int j = 1; j < (cheese[0].length - 1); j++) {
                if (cheese[i][j] == 1)
                    if (contactAir(cheese, i, j)) {
                        int[] idx = {i, j};
                        outCheeseIndex.add(idx);
                    }
            }
        }
        return outCheeseIndex;
    }

    // 외부 공기와 접촉(주변에 2칸 이상 0)인지 확인
    private static boolean contactAir(int[][] cheese, int i, int j) {
        int surface = 0;

        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                // 외부 공기와 접촉하는지
                if (cheese[i + k][j + l] == 2 && l * k == 0) surface++;
            }
        }
        return surface > 1;
    }

    // 치즈가 남아있는지 확인
    private static boolean isCheese(int[][] cheese) {
        for (int[] row : cheese) {
            for (int c : row) {
                if (c == 1) return true;
            }
        }
        return false;
    }
}
