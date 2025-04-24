package ch11.sec02.exam01;

public class ExceptionHabdlingExample1 {
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수: "+result);
        } catch (NullPointerException e) {
            // 예외 객체의 메시지로 출력
            System.out.println(e.getMessage());
            // 스택 추적 내용을 모두 출력
            e.printStackTrace(System.out);
        }
    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        // data가 null이기 때문에 NullPointerException 발생
        printLength(null); //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
        System.out.println("[프로그램 종료]");
    }
}
