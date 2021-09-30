import java.util.Scanner;

public class AcmHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testNum = Integer.parseInt(sc.nextLine());

        int h, w, gN, xx, yy;
        int[][] answer = new int[2][testNum];

        for (int i = 0; i < testNum; i++){
            h = Integer.parseInt(sc.next());
            w = Integer.parseInt(sc.next());
            gN = Integer.parseInt(sc.next());

            // 꼭대기층의 경우 나머지가 0이므로 yy에 높이를
            yy = (gN - 1) % h + 1  ;

            // 1호실부터 시작이므로 1을 더해줌
            xx = (gN - 1) / h + 1;

            // 정답 배열에 저장
            answer[0][i] = yy;
            answer[1][i] = xx;
       }

        // 정답 출력
        for (int i = 0; i < testNum; i++){
            System.out.printf("%d%02d\n", answer[0][i], answer[1][i]);
        }
    }
}
