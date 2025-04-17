package ch02.sec01;

public class VariableInitializationExample {
    public static void main(String[] args) {
        int value;
        int result = value + 10; // value에 할당된 값이 없어 error
        System.out.println(value, result);
    }
}
