package ch03.sec04;

public class AccuracyExample2 {
    public static void main(String[] args) {
        int apple = 1;
        int totalPiece = apple * 10;
        int number = 7;

        double result = totalPiece - number;
        System.out.println("10조각에서 남은 조각: "+result); // 10조각에서 남은 조각: 3.0
        System.out.println("사과 한 개에서 남은 양: "+result/10.0); // 사과 한 개에서 남은 양: 0.3
    }
}
