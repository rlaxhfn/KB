package ch13.sec02.exam02;

public class CarAgency implements Rentable<Car>{
    public Car rent() {
        return new Car();
    }
}
