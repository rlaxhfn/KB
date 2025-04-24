package ch06.sec08.exam02;

public class Computer {
    // 가변길이 매개변수를 받는 메소드
    int sum(int ...values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
}
