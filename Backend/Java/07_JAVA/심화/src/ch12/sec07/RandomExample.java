package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();
        int[] selectNum = new int[6];
        System.out.print("선택번호: ");
        for (int i = 0; i < selectNum.length; i++) {
            selectNum[i] = random.nextInt(45)+1;
            if(i==selectNum.length-1) {
                System.out.println(selectNum[i]);
            } else {System.out.print(selectNum[i]+", ");}
        }

        int[] winningNum = new int[6];
        System.out.print("당첨번호: ");
        for (int i = 0; i < winningNum.length; i++) {
            winningNum[i] = random.nextInt(45)+1;
            if(i==selectNum.length-1) {
                System.out.println(selectNum[i]);
            } else {System.out.print(winningNum[i]+", ");}
        }

        Arrays.sort(selectNum);
        Arrays.sort(winningNum);
        System.out.print("결과확인: ");
        if(Arrays.equals(selectNum, winningNum)) {
            System.out.println("1등에 당첨됐습니다!");
        } else {System.out.println("다음 기회에");}
    }
}
