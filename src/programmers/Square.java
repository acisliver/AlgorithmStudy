package programmers;

// 멀쩡한 사각형
// https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
public class Square {

    public static void main(String[] args) {
        Square s = new Square();
        System.out.println(s.solution(2, 4));
    }

    public long solution(int w, int h) {
        if (w == 1 || h == 1) return 0;

        long unUse = 0;
        double to = 0;
        double from;
        for (long i = 1; i <= w; i++) {
            from = Math.ceil(i * h / (double) w);
            if (from > to + 1) {
                unUse += from - to;
            } else {
                unUse++;
            }
            to = Math.floor(i * h / (double) w);
        }

        return ((long) w * h) - unUse;
    }
}
