package ch02.sec13;

import java.util.Scanner;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while (true) { // 무한 루프
            System.out.print("입력 문자열: ");
            str = sc.nextLine();

            if(str.equals("q")) {
                System.out.println("종료");
                break;
            }
            System.out.println("출력 문자열: "+str);
        }
    }
}
