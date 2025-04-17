package ch02.sec13;

import java.util.Scanner; // Scanner 클래스

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("x 값 입력: ");
        int x = scanner.nextInt();

        System.out.print("y 값 입력: ");
        int y = scanner.nextInt();
        System.out.println("x + y: "+ (x+y));
    }
}
