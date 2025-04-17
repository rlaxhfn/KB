package ch04.sec03;

public class SwitchNoBreakCaseExample {
    public static void main(String[] args) {
        int time = 9; // 10, 11인 경우
        System.out.println("[현재시간: "+time+"시]");

        switch (time) {
            case 9: System.out.println("출근합니다.");
            case 10: System.out.println("회의합니다.");
            case 11: System.out.println("업무 봅니다.");
            default: System.out.println("외근 나갑니다.");
        } // break이 없기 때문에 모두 출력
    }
}
