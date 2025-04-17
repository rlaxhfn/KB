package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int speed = 0;
        boolean running = true;
        while(running) {
            System.out.println("-------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("-------------------------");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    speed++;
                    System.out.println("현재 속도 = " + speed);
                    break;
                case 2:
                    speed = (speed > 0) ? speed - 1 : 0;
                    System.out.println("현재 속도 = " + speed);
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
        System.out.println("프로그램 종료1");
    }
}
