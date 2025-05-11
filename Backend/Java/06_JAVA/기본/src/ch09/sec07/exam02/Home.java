package ch09.sec07.exam02;

public class Home {
    // 필드에 익명 구현 객체 대입
    private RemoteControl rc=new RemoteControl() {
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };

    // 메소드(필드 이용)
    public void use(){
        rc.turnOn();
        rc.turnOff();
    }
}
