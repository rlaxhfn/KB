package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
        // Parent 클래스에 정의돼 있지 않아 호출 불가
        // parent.method3(); //java: cannot find symbol    symbol:   method method3()  location: variable parent of type ch07.sec07.exam02.Parent
    }
}
