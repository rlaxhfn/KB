package ch05.sec06;

public class ArrayCreateByValueListExample {
    public static void main(String[] args) {
        String[] season = {"Spring", "Summer", "Autumn", "Winter"};
        for (int i = 0; i < season.length; i++) {
            System.out.println("season["+i+"]: "+season[i]);
        }
        System.out.println();

        int[] scores = {83, 90, 87};
        int sum = 0;
        for(int s : scores) {
            sum += s;
        }
        System.out.println("총합: "+sum);
        double avg = (double) sum / scores.length;
        System.out.println("평균: "+avg);
    }
}
