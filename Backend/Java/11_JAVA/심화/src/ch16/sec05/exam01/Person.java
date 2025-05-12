package ch16.sec05.exam01;

public class Person {
    public void action(Calcuable c) {
        double res = c.calc(10, 4);
        System.out.println("결과: "+res);
    }
}
