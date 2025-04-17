package ch05;

import java.util.Scanner;

public class ScoreExample {
    public static void main(String[] args) {
        int studentNum = 0;
        int[] scores = null;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        while(run) {
            System.out.println("---------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("---------------------------------------------");
            System.out.print("선택> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("학생수> ");
                    studentNum = sc.nextInt();
                    if (studentNum <= 0) {
                        System.out.println("1명 이상 입력해주세요.");
                    }
                    scores = new int[studentNum];
                    break;
                case 2:
                    if (studentNum == 0) {
                        System.out.println("먼저 학생수를 입력하세요.");
                        break;
                    }
                    for (int i = 0; i < studentNum; i++) {
                        // 0~100만 입력받는 조건
                        while(true) {
                            System.out.print("scores[" + i + "]> ");
                            int score = sc.nextInt();
                            if (score < 0 || score > 100) {
                                System.out.println("점수는 0에서 100점 사이로 입력하세요.");
                            } else {
                                scores[i] = score;
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    if (scores == null) {
                        // 학생수를 입력 안 한 경우
                        System.out.println("먼저 학생수를 입력하세요.");
                        break;
                    }
                    for (int i = 0; i < studentNum; i++) {
                        System.out.println("scores[" + i + "]: " + scores[i]);
                    }
                    break;
                case 4:
                    if (scores == null) {
                        // 학생수를 입력 안 한 경우
                        System.out.println("먼저 학생수를 입력하세요.");
                        break;
                    }
                    int sum = 0;
                    int maxScore = 0;
                    for (int score : scores) {
                        sum += score;
                        if (score > maxScore) {
                            maxScore = score;
                        }
                    }
                    double avgScore = (double) sum / studentNum;
                    System.out.println("최고 점수: " + maxScore);
                    System.out.println("평균 점수: " + avgScore);
                    break;
                case 5:
                    run = false;
                    System.out.println("프로그램 종료");
                    break;
            }
            System.out.println();
        }
    }
}
