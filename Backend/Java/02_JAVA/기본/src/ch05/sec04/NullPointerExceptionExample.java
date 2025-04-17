package ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
        // intArray[0] = 10; // null이기 때문에 intArray[0]은 존재하지 않음, NullPointerException

        String str = null;
        // System.out.println("총 문자 수: " +str.length()); // null이기 때문에 str.length() 측정 불가, NullPointerException
    }
}
