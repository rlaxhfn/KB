package ch05.sec06;

public class ArrayLengthExample {
    public static void main(String[] args) {
        int[] scores = new int[]{84, 90, 96};
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        double avg = (double) sum/scores.length;
        System.out.println("총합: "+sum);
        System.out.println("평균: "+avg);
    }
}
