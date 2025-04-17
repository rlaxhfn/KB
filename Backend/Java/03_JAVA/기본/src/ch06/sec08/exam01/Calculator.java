package ch06.sec08.exam01;

public class Calculator {
    // 리턴값 없는 메소드
    void powerOn() {
        System.out.println("전원을 켭니다.");
    }
    void powerOff() {
        System.out.println("전원을 끕니다.");
    }
    
    // 리턴값 있는 메소드
    int plus(int a, int b) {
        return a + b;
    }

    double divide(int a, int b) {
        return (double)a / b;
    }
}
