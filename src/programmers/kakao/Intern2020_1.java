package programmers.kakao;

// https://programmers.co.kr/learn/courses/30/lessons/67256
// 키패드 누르기
public class Intern2020_1 {
    public static void main(String[] args) {
        Intern2020_1 s = new Intern2020_1();
        System.out.println(s.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }

    public String solution(int[] numbers, String hand) {

        int left = 10;
        int right = 12;

        StringBuilder answer = new StringBuilder();

        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7:
                    answer.append("L");
                    left = number;
                    break;
                case 3:
                case 6:
                case 9:
                    answer.append("R");
                    right = number;
                    break;
                case 2:
                case 5:
                case 8:
                case 0:
                     if (getDis(number, left) == getDis(number, right)) {
                        if (hand.equals("right")) {
                            answer.append("R");
                            right = number;
                        } else {
                            answer.append("L");
                            left = number;
                        }
                    } else if (getDis(number, left) > getDis(number, right)) {
                        answer.append("R");
                        right = number;
                    } else {
                        answer.append("L");
                        left = number;
                    }
                    break;
                default:
                    break;
            }
        }
        return answer.toString();
    }

    public int getDis(int from, int to) {
        if (from == 0) {
            from = 11;
        }

        if (to == 0) {
            to = 11;
        }

        int x1, y1, x2, y2;
        x1 = (from - 1) / 3;
        y1 = (from - 1) % 3;
        x2 = (to - 1) / 3;
        y2 = (to - 1) % 3;


        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
