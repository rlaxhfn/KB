package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane supersonic = new SupersonicAirplane();
        supersonic.takeOff();
        supersonic.fly();
        supersonic.flyMode = SupersonicAirplane.SUPERSONIC;
        supersonic.fly();
        supersonic.flyMode = SupersonicAirplane.NORMAL;
        supersonic.fly();
        supersonic.land();
    }
}
