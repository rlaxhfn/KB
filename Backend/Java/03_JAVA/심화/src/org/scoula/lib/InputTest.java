package org.scoula.lib;

public class InputTest {
    public static void main(String[] args) {
        System.out.println("입력값: "+Input.read("이름"));
        System.out.println("입력값: "+Input.read("이름", "홍길동"));
        System.out.println("입력값: "+Input.readInt("나이"));
        System.out.println("입력값: "+Input.confirm("종료할까요?"));
        System.out.println("입력값: "+Input.confirm("종요할까요?", true));
    }
}
