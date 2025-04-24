package ch07.sec04.exam01;

import java.util.Scanner;

public class ComputerExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름: ");
        int r = sc.nextInt();

        Calculator calc = new Calculator();
        System.out.println("원 면적: "+calc.areaCircle(r));

        Computer computer = new Computer();
        System.out.println("원 면적: "+computer.areaCircle(r));
    }
}
