package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        System.out.println("메시지를 입력하세요.");
        System.out.println("프로그램을 종료하려면 q를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input;
        do {
        System.out.print("> ");
        input = sc.nextLine();
        System.out.println(input);
        } while (!input.equals("q")); // equalsIgnoreCase : 대소문자 구분 없음
        System.out.println();
        System.out.println("프로그램 종료");
    }
}
