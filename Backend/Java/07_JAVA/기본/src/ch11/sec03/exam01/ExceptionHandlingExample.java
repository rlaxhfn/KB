package ch11.sec03.exam01;

import java.lang.reflect.Array;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};
        for(int i=0; i<=array.length; i++) {
            // 다중 예외 처리 코드 추가
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스 초과: "+e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("숫자 타입 아님: "+e.getMessage());
            }
        }
    }
}
