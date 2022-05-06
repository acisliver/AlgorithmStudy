package programmers.kakao;

import java.util.LinkedList;

// https://programmers.co.kr/learn/courses/30/lessons/67257
// 수식 최대화
public class Intern2020_2 {
    public static void main(String[] args) {
        Intern2020_2 s = new Intern2020_2();
        System.out.println(s.solution("100-200*300-500+20"));
    }

    public long solution(String expression) {
        long answer = 0;

        String[] operand = expression.split("\\*|\\+|-");
        String[] operator = expression.split("[0-9]+");

        LinkedList<Long> operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        LinkedList<String> operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }

        // * + -
        mul(operandList, operatorList);
        plus(operandList, operatorList);
        minus(operandList, operatorList);
        answer = Math.max(answer, Math.abs(operandList.pop()));

        operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }

        // * - +
        mul(operandList, operatorList);
        minus(operandList, operatorList);
        plus(operandList, operatorList);
        answer = Math.max(answer, Math.abs(operandList.pop()));

        operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }

        // + * -
        plus(operandList, operatorList);
        mul(operandList, operatorList);
        minus(operandList, operatorList);
        answer = Math.max(answer, Math.abs(operandList.pop()));

        operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }

        // + - *
        plus(operandList, operatorList);
        minus(operandList, operatorList);
        mul(operandList, operatorList);
        answer = Math.max(answer, Math.abs(operandList.pop()));

        operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }

        // - * +
        minus(operandList, operatorList);
        mul(operandList, operatorList);
        plus(operandList, operatorList);
        answer = Math.max(answer, Math.abs(operandList.pop()));

        operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }

        // - + *
        minus(operandList, operatorList);
        plus(operandList, operatorList);
        mul(operandList, operatorList);
        answer = Math.max(answer, Math.abs(operandList.pop()));

        operandList = new LinkedList<>();
        for (String s : operand) {
            operandList.add(Long.parseLong(s));
        }

        operatorList = new LinkedList<>();
        for (int i = 1; i < operator.length; i++) {
            operatorList.add(operator[i]);
        }


        return answer;
    }

    public void mul(LinkedList<Long> operandList, LinkedList<String> operatorList) {
        while(operatorList.contains("*")) {
            int operatorW = operatorList.indexOf("*");
            long operand1 = operandList.get(operatorW);
            long operand2 = operandList.get(operatorW + 1);
            long result = operand1 * operand2;

            operatorList.remove(operatorW);
            operandList.remove(operatorW + 1);
            operandList.set(operatorW, result);
        }
    }

    public void plus(LinkedList<Long> operandList, LinkedList<String> operatorList) {
        while(operatorList.contains("+")) {
            int operatorW = operatorList.indexOf("+");
            long operand1 = operandList.get(operatorW);
            long operand2 = operandList.get(operatorW + 1);
            long result = operand1 + operand2;

            operatorList.remove(operatorW);
            operandList.remove(operatorW + 1);
            operandList.set(operatorW, result);
        }
    }

    public void minus(LinkedList<Long> operandList, LinkedList<String> operatorList) {
        while(operatorList.contains("-")) {
            int operatorW = operatorList.indexOf("-");
            long operand1 = operandList.get(operatorW);
            long operand2 = operandList.get(operatorW + 1);
            long result = operand1 - operand2;

            operatorList.remove(operatorW);
            operandList.remove(operatorW + 1);
            operandList.set(operatorW, result);
        }
    }
}
