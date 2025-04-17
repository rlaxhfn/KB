package ch04;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        int balance = 0;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while(run) {
            System.out.println("-----------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-----------------------------");
            System.out.print("선택> ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("예금액> ");
                    int moneyIn = sc.nextInt();
                    balance += moneyIn;
                    break;
                case 2:
                   System.out.print("출금액> ");
                   int moneyOut = sc.nextInt();
                   if(moneyOut > balance) {
                       System.out.println("잔고가 부족합니다.");
                       break;
                   }
                   System.out.println();
                   balance -= moneyOut;
                   break;
                case 3:
                    System.out.println("잔고> "+balance);
                    break;
                case 4:
                    run = false;
                    break;
            }
            System.out.println();
        }
        System.out.println("프로그램 종료");
    }
}
