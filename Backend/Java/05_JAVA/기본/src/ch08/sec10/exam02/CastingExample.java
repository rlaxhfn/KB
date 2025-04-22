package ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        // Vehicle Interface에 checkFare이 선언되지 않았기 때문에 호출 불가
        // vehicle.checkFare(); // java: cannot find symbol    symbol:   method checkFare()    location: variable vehicle of type ch08.sec10.exam02.Vehicle

        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }
}
