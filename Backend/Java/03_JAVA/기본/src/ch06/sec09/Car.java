package ch06.sec09;

public class Car {
    // 필드 선언
    String model;
    int speed;

    // 생성자 선언
    Car(String model) {
        this.model = model;
    } //model 필드는 생성자로 초기화

    // 메소드 선언
    // speed 필드의 getter/setter 메소드 정의
    void setSpeed(int speed) {
        this.speed = speed;
    }
    int getSpeed() {
        return this.speed;
    }

    // run() 메소드 호출 출력
    void run() {
        System.out.println(model+"이/가 달립니다.(시속 "+speed+"km/h)");
    }
}
