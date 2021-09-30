import java.util.Scanner;

/**
 * 조건
 * 1. 3kg, 5kg 봉지가 있다
 * 2. 설탕을 봉지에 나누어 가져가야 한다
 * 3. 봉지의 개수는 적을수록 좋다
 * 4. 만약 적확하게 N 킬로그램을 만들 수 없다면 -1을 출력한다
 * 테스트 케이스
 * 1. 5의 배수
 * 2. 3의 배수
 * 3. 5의 배수와 3의 배수의 합
 * 4. 그 외
 */
public class SugarDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sugar = sc.nextInt();

        int answer = getBong2(sugar);
        System.out.println(answer);
    }

    public static int getBong1(int sugar) {

        int bong3 = 0;
        int bong5 = sugar / 5;

        int mod = sugar % 5;

        switch (mod){
            case 0:
                break;
            case 1:
                bong5--;
                if (bong5 < 0) return -1;
                bong3 += 2;
                break;
            case 2:
                bong5 -= 2;
                if (bong5 < 0) return -1;
                bong3 += 4;
                break;
            case 3:
                bong3++;
                break;
            case 4:
                bong5--;
                if (bong5 < 0) return -1;
                bong3 += 3;
                break;
        }

        return (bong3 + bong5);
    }

    // Brute Force Algorithm
    // 가능한 모든 경우 탐색
    public static int getBong2(int sugar){

        int MAX = sugar / 3 + 1;

        int bongN;
        int min = MAX;

        for(int bong5 = 0; bong5 * 5 <=sugar; bong5++) {
            for (int bong3 = 0; bong3 * 3 <=sugar; bong3++){
                if((bong5 * 5 + bong3 * 3) == sugar) {
                    bongN = bong5 + bong3;
                    if(min > bongN) min = bongN;
                }
            }
        }

        return (min == MAX) ? -1 : min;
    }

}
