package ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        long startTime=System.nanoTime(); // 시작 시간 기록
        int sum=0;
        for (int i=1;i<=1000000;i++) {
            sum+=i;
        }
        long endTime=System.nanoTime(); // 끝 시간 기록
        long elapsedTime=endTime-startTime; // 소요시간=끝-시작

        System.out.println("1부터 1,000,000까지의 합 = "+sum);
        System.out.println("소요시간: "+elapsedTime+"나노초");

    }
}
